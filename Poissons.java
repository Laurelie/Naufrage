public abstract class Poissons extends Animaux implements Pechable{
	protected Poissons(String nom, int poids, int rapportAlimentaire){
		 super(nom,poids,rapportAlimentaire,true,true); //ajout pour vivant et cru
	 }
	public Pechable estPecher(Personnage p){
		txt.textAffichage("Vous avez une touche !\n");
		if (Math.random()<0.5){
			txt.textAffichage("Vous tirez comme un malade et vous sortez : "+super.toString()+"\n");
			setVivant(false);
			this.reagirPeche(p);
		}
		else 
			txt.textAffichage("Bien essayé "+p.getNom()+" ! Vous manquez de peu votre proie !\n");
		return this;
	}
	public void reagirPeche( Personnage p){
    	if(Math.random()<0.7){
      		txt.textAffichage(super.toString()+" est mort quand vous le ramenez à bord\n");
    	}
    	else{
    		txt.textAffichage(super.toString()+" vous donne un coup de queue avant de mourir. Vous retire 3 PV\n");
      		p.modifierSante(-3);
    	}
  	}
}
