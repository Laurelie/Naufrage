import java.util.ArrayList;

public class CannePeche implements Fabricable{ //extends Construction { //on doit pouvoir l'utiliser sans etre sur un camp
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
	public String toString() {
		return "Canne a Peche";
	}
	public static int getNbCannePeche() {
		return nbCannePeche;
	}
	//ce qui est en plus dans construction
	public int getPoids() {
		return 0;
	}
	public int getQuantite() {
		return 1;
	}
	public void modifierQuantite(int n){
		
	}
}
