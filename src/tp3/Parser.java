package tp3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser<ParsedBase> {

	private List<ParserFactory<? extends ParsedBase>> _factories;

	public Parser() {
		_factories = new ArrayList<>();
	}

	public void addFactory(ParserFactory<? extends ParsedBase> pf) {
		_factories.add(pf);
	}

	public ParsedBase parseOne(String line) throws ParseException {
		String[] args = line.split("#");

		ParsedBase object;
		for (ParserFactory<? extends ParsedBase> factory : _factories)
			if ((object = factory.tryConstruct(args)) != null)
				return object;

		throw new ParseException();
	}

	public List<ParsedBase> parse(Scanner data) throws ParseException {
		List<ParsedBase> result = new ArrayList<>();

		while (data.hasNextLine())
			result.add(parseOne(data.nextLine()));

		return result;
	}

	public List<ParsedBase> parse(InputStream data) throws ParseException {
		return parse(new Scanner(data));
	}

	public List<ParsedBase> parseFile(String fileName) throws FileNotFoundException, ParseException {
		return parse(new FileInputStream(fileName));
	}
}
