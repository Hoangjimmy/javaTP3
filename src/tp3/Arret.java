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
public class Arret {

	private int _id;
	private double _longi, _lati;
	private String _name;
	private String _arrondissement;

	public Arret(int id, double longitude, double latitude, String name, String arrondissement) {

		_id = id;
		_longi = longitude;
		_lati = latitude;
		_name = name;
		_arrondissement = arrondissement;

	}

	/**
	 * @return the _id
	 */
	public int getId() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void setId(int _id) {
		this._id = _id;
	}

	/**
	 * @return the _longi
	 */
	public double getLongi() {
		return _longi;
	}

	/**
	 * @param _longi the _longi to set
	 */
	public void setLongi(double _longi) {
		this._longi = _longi;
	}

	/**
	 * @return the _lati
	 */
	public double getLati() {
		return _lati;
	}

	/**
	 * @param _lati the _lati to set
	 */
	public void setLati(double _lati) {
		this._lati = _lati;
	}

	/**
	 * @return the _name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @param _name the _name to set
	 */
	public void setName(String _name) {
		this._name = _name;
	}

	/**
	 * @return the _arrondissement
	 */
	public String getArrondissement() {
		return _arrondissement;
	}

	/**
	 * @param _arrondissement the _arrondissement to set
	 */
	public void setArrondissement(String _arrondissement) {
		this._arrondissement = _arrondissement;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Arret))
			return false;
		Arret a = (Arret) o;
		return a.getId() == this._id
				&& a.getLongi() == this._longi
				&& a.getLati() == this._lati
				&& a.getArrondissement().equals(this._arrondissement)
				&& a.getName().equals(this._name);
	}
}
