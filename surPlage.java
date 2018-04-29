public abstract class surPlage implements Pechable{
	protected String nom;
	protected int poids;
	private int quantite = 1;
	public surPlage(String nom, int poids){
		this.nom = nom;
		this.poids = poids;
	}
	public String toString(){
		return nom;
	}
	public Pechable estPecher(Personnage p){
		System.out.println("Vous avez une touche !");
		if (Math.random()<0.7){
			System.out.println("Vous tirez comme un malade et vous sortez : "+super.toString());
		}
		else 
			System.out.println("Vous manquez de peu votre proie !");
		return this;
	}
	public void reagirPeche(Personnage p){
		return;
	}
	public int getPoids(){
		return poids;
	}
    public  int getQuantite(){
    	return quantite;
    }
	public void modifierQuantite(int n) {
		quantite+=n;
	}
}