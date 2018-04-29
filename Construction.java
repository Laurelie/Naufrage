import java.util.ArrayList;

public abstract class Construction implements Fabricable{
	public int getPoids() {
		return 0;
	}
	public int getQuantite() {
		return 1;
	}
	public void modifierQuantite(int n) {}
	public abstract ArrayList<Stockable> listeMateriaux();
	public abstract Stockable clone();
	public abstract void interagir(Personnage p);
}
