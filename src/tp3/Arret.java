package tp3;

/**
 * Un arrêt de transport en commun
 */
public class Arret {

	/**
	 * L'identifiant de l'arrêt
	 */
	private int _id;
	/**
	 * Les coordonnées géoraphiques de l'arrêt
	 */
	private double _longi, _lati;
	/**
	 * Le nom de l'arrêt
	 */
	private String _name;
	/**
	 * L'arrondissment de l'arrêt
	 */
	private String _arrondissement;

	/**
	 *
	 * @param id	L'identifiant de l'arrêt
	 * @param longitude	La longitude de l'arrêt
	 * @param latitude	La latitude de l'arrêt
	 * @param name	Le nom de l'arrêt
	 * @param arrondissement	L'arrondissment de l'arrêt
	 */
	public Arret(int id, double longitude, double latitude, String name, String arrondissement) {

		_id = id;
		_longi = longitude;
		_lati = latitude;
		_name = name;
		_arrondissement = arrondissement;

	}

	/**
	 * @return L'identifiant de l'arrêt
	 */
	public int getId() {
		return _id;
	}

	/**
	 * @param _id L'identifiant de l'arrêt
	 */
	public void setId(int _id) {
		this._id = _id;
	}

	/**
	 * @return La longitude de l'arrêt
	 */
	public double getLongi() {
		return _longi;
	}

	/**
	 * @param _longi La longitude de l'arrêt
	 */
	public void setLongi(double _longi) {
		this._longi = _longi;
	}

	/**
	 * @return La latitude de l'arrêt
	 */
	public double getLati() {
		return _lati;
	}

	/**
	 * @param _lati La latitude de l'arrêt
	 */
	public void setLati(double _lati) {
		this._lati = _lati;
	}

	/**
	 * @return Le nom de l'arrêt
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @param _name Le nom de l'arrêt
	 */
	public void setName(String _name) {
		this._name = _name;
	}

	/**
	 * @return L'arrondissment de l'arrêt
	 */
	public String getArrondissement() {
		return _arrondissement;
	}

	/**
	 * @param _arrondissement L'arrondissment de l'arrêt
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
