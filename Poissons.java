public abstract class Poissons extends Animaux implements Pechable{
	protected Poissons(String nom, int poids, int rapportAlimentaire){
		 super(nom,poids,rapportAlimentaire,true,true); //ajout pour vivant et cru
	 }
	public Pechable estPecher(Personnage p){
		System.out.println("Vous avez une touche !");
		if (Math.random()<0.5){
			System.out.println("Vous tirez comme un malade et vous sortez : "+super.toString());
			setVivant(false);
			this.reagirPeche(p);
		}
		else 
			System.out.println("Vous manquez de peu votre proie !");
		return this;
	}
	public void reagirPeche( Personnage p){
    	if(Math.random()<0.7){
      		System.out.println("Le "+super.toString()+" est mort quand vous le ramenez à bord");
    	}
    	else{
    		System.out.println(super.toString()+" vous donne un coup de queue avant de mourir. Vous retire 3 PV");
      		p.modifierSante(-3);
    	}
  	}
}
