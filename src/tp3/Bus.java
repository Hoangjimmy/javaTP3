package tp3;

/**
 * Un arr^t de bus.
 */
public class Bus extends Arret {

	public Bus(int id, double longitude, double latitude, String name, String arrondissement) {
		super(id, longitude, latitude, name, arrondissement);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Arret))
			return false;
		Bus b = (Bus) o;
		return b.getId() == this.getId()
				&& b.getLongi() == this.getLongi()
				&& b.getLati() == this.getLati()
				&& b.getArrondissement().equals(this.getArrondissement())
				&& b.getName().equals(this.getName());
	}

	public String toString() {
		return super.toString() + " [bus]";
	}
}
