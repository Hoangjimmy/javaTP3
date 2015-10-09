package tp3;

import java.util.Comparator;

public abstract class ArretComparators {

	public static final Comparator<Arret> parId = new Comparator<Arret>() {
		@Override
		public int compare(Arret lhs, Arret rhs) {
			return Integer.compare(lhs.getId(), rhs.getId());
		}
	};
	
	public static final Comparator<Arret> parArrondissmentEtNom = new Comparator<Arret>() {

		@Override
		public int compare(Arret lhs, Arret rhs) {
			int c = lhs.getArrondissement().compareTo(rhs.getArrondissement());
			if (c != 0)
				return c;

			c = lhs.getName().compareTo(rhs.getName());
			return c;
		}
	};
}
