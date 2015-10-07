package tp3;

public class BusFactory implements ParserFactory<Bus> {

	@Override
	public Bus tryConstruct(String[] args) {
		if (args.length != 6)
			return null;

		if (!args[5].equals("bus"))
			return null;

		try {
			return new Bus(Integer.parseInt(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]), args[3], args[4]);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
