package tp3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hoangjim
 */
public class MetroFactory implements ParserFactory<Metro> {

	@Override
	public Metro tryConstruct(String[] args) {
		if (args.length != 6 || !args[5].equals("metro"))
			return null;

		try {
			return new Metro(
					Integer.parseInt(args[0]),
					Double.parseDouble(args[1]),
					Double.parseDouble(args[2]),
					args[3],
					args[4]
			);
		} catch (NumberFormatException n) {
			return null;
		}
	}

}
