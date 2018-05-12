public class Crabe extends AnimauxChassable{
	public Crabe(){
		super("Crabe", 10, 10, 10);
	}
	public void reagirAttaque( Personnage p){
	    if(Math.random()<0.5){
	      txt.textAffichage("La pince du crabe vous manque de peu\n");
	    }
	    else{
	      txt.textAffichage("Vous vous faites pincer l'orteil ! -7 PV\n");
	      p.modifierSante(-7);
	    }
	}
}
