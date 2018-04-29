import java.util.ArrayList;

public class Camp extends Construction {
	private static int nbCamps = 0;
	public Camp() {
		nbCamps++;
	}
	public ArrayList<Stockable> listeMateriaux() {
		ArrayList<Stockable> liste = new ArrayList<Stockable>();
		liste.add(new Bois(10));
		return liste;
	}
	public Stockable clone() {
		return new Camp();
	}
	public void interagir(Personnage p) {
	}
	public String toString() {
		return "Camp";
	}
	public static int getNbCamps() {
		return nbCamps;
	}
}
