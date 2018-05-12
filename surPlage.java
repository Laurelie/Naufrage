public abstract class surPlage implements Pechable{
	protected Txt txt = new Txt();
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
		txt.textAffichage("Vous avez une touche !");
		if (Math.random()<0.7){
			txt.textAffichage("Vous tirez comme un malade et vous sortez : "+super.toString()+"\n");
		}
		else 
			txt.textAffichage("Vous manquez de peu votre proie !\n");
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