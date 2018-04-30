public abstract class Fruits implements Mangeable{
	private boolean poison;
	private String nom;
	private int rapportAlimentaire;
	private int poids;
	private int quantite;
	public Fruits(String nom, boolean poison, int poids, int rapportAlimentaire){
		this.nom = nom;
		this.poison = poison;
		this.poids = poids;
		this.rapportAlimentaire = rapportAlimentaire;
		this.quantite = 0;
	}
    public int getPoids(){
    	return poids;
    }
   	public int getQuantite() {
		return quantite;
	}
	public void modifierQuantite(int n) {
		quantite += n;
	}
    public int estMange(Personnage p){ 
		if (poison){
	    	System.out.println("Vous mangez "+nom+" empoisonne : -"+rapportAlimentaire+" de santé");
	    	return 0-rapportAlimentaire;
	  	}
	  	else{
	    	System.out.println("Vous mangez "+nom+" +"+rapportAlimentaire+" de santé");
	    	return rapportAlimentaire;
	  	}
	}
  	public void estCuisine(){}
  	public String toString(){
  		return nom;
  	}
}
