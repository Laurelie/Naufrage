import java.util.ArrayList;

public class CannePeche extends Construction {
	private static int nbCannePeche = 0;
	public CannePeche() {
		nbCannePeche++;
	}
	public ArrayList<Stockable> listeMateriaux() {
		ArrayList<Stockable> liste = new ArrayList<Stockable>();
		liste.add(new Bois(2));
		liste.add(new Fil(1));
		return liste;
	}
	public Stockable clone() {
		return new CannePeche();
	}
	public void interagir(Personnage p) {
	}
	public String toString() {
		return "Canne a Peche";
	}
	public static int getNbCannePeche() {
		return nbCannePeche;
	}
}
