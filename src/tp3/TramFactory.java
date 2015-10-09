package tp3;

/**
 * Une fabrique d'arrêts de tramway
 */
public class TramFactory implements ParserFactory<Tram> {

    @Override
    public Tram tryConstruct(String[] args) {
        if (args.length != 6 || !args[5].equals("tram")) {
            return null;
        }

        try {
            return new Tram(
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
