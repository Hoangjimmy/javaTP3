package tp3;

public class Tram extends Arret {

	public Tram(int id, double longitude, double latitude, String name, String arrondissement) {
		super(id, longitude, latitude, name, arrondissement);
	}

	@Override
	public String toString() {
		return super.toString() + " [tram]";
	}
}
