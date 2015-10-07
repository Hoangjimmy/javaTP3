package tp3;

public class Metro extends Arret {

	public Metro(int id, double longitude, double latitude, String name, String arrondissement) {
		super(id, longitude, latitude, name, arrondissement);
	}

	@Override
	public String toString() {
		return super.toString() + " [metro]";
	}
}
