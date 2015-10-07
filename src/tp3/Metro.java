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
public class Metro extends Arret {

	public Metro(int id, double longitude, double latitude, String name, String arrondissement) {
		super(id, longitude, latitude, name, arrondissement);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Metro))
			return false;
		Metro m = (Metro) o;
		return m.getId() == this.getId()
				&& m.getLongi() == this.getLongi()
				&& m.getLati() == this.getLati()
				&& m.getArrondissement().equals(this.getArrondissement())
				&& m.getName().equals(this.getName());
	}
	
	public String toString() {
		return super.toString() + " [metro]";
	}
}
