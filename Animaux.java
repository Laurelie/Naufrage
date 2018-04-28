public abstract class Animaux implements Mangeable{
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
	public void setRapportAlimentaire(int rapportAlimentaire){ //LAU
		rapportAlimentaire = this.rapportAlimentaire;
	}
	public void setVivant(boolean vivant){ //LAU
		this.vivant = vivant;
	}
	public boolean getVivant(){ //LAU
		return vivant;
	}
	public void setCru(boolean cru){ //LAU
		this.cru = cru;
	}
	public int getPoids(){ //LAU
	  	return poids;
	}
	public String desc(){ //LAU
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
	public int estMange(Personnage p){ //LAU
		if (cru){
	    	System.out.println("Vous mangez un "+nom+" cru : -"+rapportAlimentaire+" de santé");
	    	return 0-rapportAlimentaire;
	  	}
	  	else{
	    	System.out.println("Vous mangez un "+nom+" cuisiné : +"+rapportAlimentaire+" de santé");
	    	return rapportAlimentaire;
	  	}
	}
	public void estCuisine(){ //LAU
	  	if (!vivant){ //vivant == False
	    	cru = false;
	  	}
	  	else
	    	System.out.println("On ne peut pas cuisiné un "+nom+" vivant");
	}
	  public int getQuantite() {
		  return quantite;
	  }
	  public void modifierQuantite(int n) {
		  quantite+=n;
	  }
}
