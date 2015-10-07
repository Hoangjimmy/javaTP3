package tp3;

public class Bus extends Arret{
	public Bus(int id, double longitude, double latitude, String name, String arrondissement) {
		super(id, longitude, latitude, name, arrondissement);
	}

	@Override
	public String toString() {
		return super.toString() + " [bus]";
	}
}
