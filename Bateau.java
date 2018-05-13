import java.util.ArrayList;

public class Bateau extends Construction {
	private static int nbBateau = 0;
	public Bateau() {
		nbBateau++;
		if (nbBateau==2) {
			txt.textAffichage("Bravo vous a finallement réussi à réparer le bateau des indigènes!!! \n Vous réussissez à vous enfuire avec... En seulement " + Personnage.getDate() + "jours!");
			}
		}
	public static int getNbBateau() {
		return nbBateau;
	}
	public ArrayList<Stockable> listeMateriaux() {
		ArrayList<Stockable> a = new ArrayList<Stockable>();
		a.add(new Bois(20));
		a.add(new Fil(5));
		return a;
	}
	public Stockable clone() {
		return new Bateau();
	}

	public void interagir(Personnage p) {
	}
	
}
