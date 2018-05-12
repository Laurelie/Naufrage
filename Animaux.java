public abstract class Animaux extends Txt implements Mangeable{
	protected static Txt txt = new Txt(); //evite de l'insancier à chaque fois
	private int quantite = 1;
	private int poids;/* vu qu'on a un accesseur on peut le mettre private*/
	protected String nom;
	private int rapportAlimentaire;
	private boolean vivant;
	private boolean cru;
	public Animaux(String nom, int poids, int rapportAlimentaire, boolean vivant, boolean cru){
	  	this.poids = poids;
	  	this.nom = nom;
	  	this.rapportAlimentaire = rapportAlimentaire;
		this.vivant = vivant;
		this.cru = cru;
		quantite = 1;
	}
	public void setRapportAlimentaire(int rapportAlimentaire){ 
		rapportAlimentaire = this.rapportAlimentaire;
	}
	public void setVivant(boolean vivant){ 
		this.vivant = vivant;
	}
	public boolean getVivant(){ 
		return vivant;
	}
	public void setCru(boolean cru){ 
		this.cru = cru;
	}
	public int getPoids(){ 
	  	return poids;
	}
	public String desc(){ 
	  	String txt = nom+" de poids :"+poids+" qui équivault à "+rapportAlimentaire+" de rapportAlimentaire. Cet animal est ";
	  	if(vivant)
	    	return txt+"vivant";
		txt+="mort et ";
		if(cru)
	    	return txt+"cru";
	  	return txt+"cuisiné";
	}
	public String toString() {
		return nom;
	}
	public int estMange(Personnage p){ 
		if (cru){
	    	txt.textAffichage("Vous mangez un "+nom+" cru : -"+rapportAlimentaire+" de santé\n");
	    	return 0-rapportAlimentaire;
	  	}
	  	else{
	    	txt.textAffichage("Vous mangez un "+nom+" cuisiné : +"+rapportAlimentaire+" de santé\n");
	    	return rapportAlimentaire;
	  	}
	}
	public void estCuisine(){ 
	  	if (!vivant){ //vivant == False
	    	cru = false;
	  	}
	  	else
	    	txt.textAffichage("On ne peut pas cuisiné un "+nom+" vivant\n");
	}
	  public int getQuantite() {
		  return quantite;
	  }
	  public void modifierQuantite(int n) {
		  quantite+=n;
	  }
}
