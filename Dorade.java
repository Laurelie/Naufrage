public class Dorade extends Poissons{
	public Dorade(){
		super("Dorade",30,30);
	}
	public void reagirPeche( Personnage p){
    	if(Math.random()<0.5){
      		txt.textAffichage("La "+super.toString()+" est mort quand vous le ramenez à bord\n");
    	}
    	else{
    		txt.textAffichage(super.toString()+" vous arrache un doigt avant de mourir. Vous retire 10 PV\n");
      		p.modifierSante(-3);
    	}
  	}
}
