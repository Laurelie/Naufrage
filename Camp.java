import java.util.ArrayList;

public class Camp extends Construction {
	private static int nbCamps = 0;
	public Camp() {
		nbCamps++;
		//new Camp() permet de pouvoir stocker un camp et de le placer sur la carte
		//txt.textAffichage("Vous avez construit un camp \n Attention! Vous ne pouvez construire que deux camps\n");
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
		txt.textAffichage("Vous ne pouvez pas interagir avec votre camp, mais il vous protege des animaux sauvages");
	}
	public String toString() {
		return "Camp";
	}
	public static int getNbCamps() {
		return nbCamps;
	}
}
