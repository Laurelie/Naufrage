public class Chamois extends AnimauxChassable{
	public Chamois(){
		super("Chamois", 20, 20, 50);
	}
	public void reagirAttaque( Personnage p){
	    if(Math.random()<0.5){
	      txt.textAffichage("Les cornes du chamois vous manque de peu\n");
	    }
	    else{
	      txt.textAffichage("Vous vous faites renverser ! -15 PV\n");
	      p.modifierSante(-15);
	    }
	}
}
