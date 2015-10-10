package tp3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Un parseur capable d'analyser des lignes de paramètres de construction
 * séparés par '#'
 *
 * @param <ParsedBase> La classe mère de tous les types qui peuvent être créés
 * via ce parseur
 */
public class Parser<ParsedBase> {

    private final List<ParserFactory<? extends ParsedBase>> _factories;

    public Parser() {
        _factories = new ArrayList<>();
    }

    /**
     * Ajoute une factory candidate pour construire un certain type d'objet
     *
     * @param pf La factory
     */
    public void addFactory(ParserFactory<? extends ParsedBase> pf) {
        _factories.add(pf);
    }

    /**
     * Parse one object.
     * @param line The string in which the parameters are stored
     * @return The constructed object, as return by the first matching factory.
     * @throws ParseException
     */
    public ParsedBase parseOne(String line) throws ParseException {
        String[] args = line.split("#");

        ParsedBase object;
        for (ParserFactory<? extends ParsedBase> factory : _factories) {
            if ((object = factory.tryConstruct(args)) != null) {
                return object;
            }
        }

        throw new ParseException();
    }

    /**
     * Parses all the available lines from the given Scanner.
     * @param data The Scanner from which to read.
     * @return The list of parsed objects.
     * @throws ParseException 
     */
    public List<ParsedBase> parse(Scanner data) throws ParseException {
        List<ParsedBase> result = new ArrayList<>();

        while (data.hasNextLine()) {
            result.add(parseOne(data.nextLine()));
        }

        return result;
    }

    /**
     * Parses all the available lines from the given InputStream.
     * @param data The InputStream from which to parse.
     * @return The list of parsed objects.
     * @throws ParseException 
     */
    public List<ParsedBase> parse(InputStream data) throws ParseException {
        return parse(new Scanner(data));
    }

    /**
     * Parse the whole file, line-by-ine.
     * @param fileName The path to the file
     * @return The list of parsed objects.
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public List<ParsedBase> parseFile(String fileName) throws FileNotFoundException, ParseException {
        return parse(new FileInputStream(fileName));
    }
}
