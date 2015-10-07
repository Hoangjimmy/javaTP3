/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 * @author hoangjim
 */
public class BusFactory implements ParserFactory<Bus> {

	@Override
	public Bus tryConstruct(String[] args) {
		if (args.length == 6 && args[5].equals("Bus"))
			return null;
		try {
			return new Bus(Integer.parseInt(args[0]),
					Double.parseDouble(args[1]),
					Double.parseDouble(args[2]),
					args[3],
					args[4]);
		} catch (NumberFormatException n) {
			return null;
		}
	}

}
