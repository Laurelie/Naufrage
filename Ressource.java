public abstract class Ressource implements Stockable{
	private int quantite;
	private String nom;
	private int poids;
	protected Ressource(String nom, int n, int poids) {
		this.nom = nom;
		quantite = n;
		this.poids = poids;
	}
	public void modifierQuantite(int n) {
		quantite += n;
	}
	public int getQuantite() {
		return quantite;
	}
	public String toString() {
		return nom;
	}
	public int getPoids() {
		return poids;
	}
}
