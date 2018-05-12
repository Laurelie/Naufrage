public abstract class AnimauxChassable extends Animaux {
	 private int sante;
	 protected AnimauxChassable(String nom, int poids, int rapportAlimentaire, int sante){
		 super(nom,poids,rapportAlimentaire,true,true); //ajout pour vivant et cru
		 this.sante = sante;
	 }
	 public int getSante(){
		    return sante;
		  }
	 public void perdSante(int nb){
		    sante=sante-nb;
		    if (sante<=0)
		    	this.setVivant(false);
		  }
  	public abstract void reagirAttaque( Personnage p);
  	public void reagirFuite(Personnage p){
  		txt.textAffichage(this.nom+" ne fait pas attention à vous\n");
  	}
  	
  	public void descriptionMort(){
  		System.out.println(this.nom+" s'effondre par terre, raide mort.\n");
     	this.setVivant(false);
  	}
  	/*public void reagirapprivoiser(Personnage p, ? implements Mangeable aliment);*/
}
