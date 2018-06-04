public class Chamois extends AnimauxChassable{
	public Chamois(){
		super("Chamois", (int)(Math.random()*20+15), (int)(Math.random()*8+18), (int)(Math.random()*8+15));
		//nom poids rapportAlimentaire sante
	}
	public void reagirAttaque( Personnage p){
	    if(Math.random()<0.5){
	      	txt.textAffichage("Les cornes du chamois vous manque de peu\n");
	    }
	    else{
	    	int blessure = (int)(Math.random()*10+11);
	      	txt.textAffichage("Vous vous faites renverser ! -"+blessure+" PV\n");
	      	p.modifierSante(-blessure);
	    }
	    if(Math.random()<0.5)
	    	reagirFuite(p);
	}
	public void reagirFuite(Personnage p){
  		txt.textAffichage("Le chamois s'enfuit dans les montagnes... hors d'atteinte\n");
  	}
}
