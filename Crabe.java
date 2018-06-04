public class Crabe extends AnimauxChassable{
	public Crabe(){
		super("Crabe", (int)(Math.random()*5+5), (int)(Math.random()*8+3), 1);
		//nom poids rapportAlimentaire sante
	}
	public void reagirAttaque( Personnage p){
	    if(Math.random()<0.5)
	      	reagirFuite(p);
	    else{
	    	int blessure = (int)(Math.random()*8+1);
	      	txt.textAffichage("Vous vous faites pincer l'orteil ! -"+blessure+" PV\n");
	      	p.modifierSante(-blessure);
	    }
	}
	public void reagirFuite(Personnage p){
          txt.textAffichage("Le crabe se cache dans l'eau !\n");
    }
}
