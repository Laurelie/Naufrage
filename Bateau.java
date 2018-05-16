import java.util.ArrayList;

public class Bateau extends Construction {
	private static int nbBateau = 0;
	public Bateau() {
		nbBateau++;
		if (nbBateau==2){ //PQ 2?
			txt.textAffichage("Bravo vous a finalement reussi a reparer le bateau des indigenes!!! \n Vous reussissez a vous enfuir avec... En seulement " + Personnage.getDate() + "jours!\n\n\t\t\tSUCCESS\n");
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
