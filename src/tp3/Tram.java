package tp3;

/**
 * Un arrêt de tramway
 */
public class Tram extends Arret {

	public Tram(int id, double longitude, double latitude, String name, String arrondissement) {
		super(id, longitude, latitude, name, arrondissement);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Tram))
			return false;
		Tram t = (Tram) o;
		return t.getId() == this.getId()
				&& t.getLongi() == this.getLongi()
				&& t.getLati() == this.getLati()
				&& t.getArrondissement().equals(this.getArrondissement())
				&& t.getName().equals(this.getName());
	}

	@Override
	public String toString() {
		return super.toString() + " [tram]";
	}
}
