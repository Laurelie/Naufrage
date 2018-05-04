public class Crabe extends AnimauxChassable{
	public Crabe(){
		super("Crabe", 10, 10, 10);
	}
	public void reagirAttaque( Personnage p){
	    if(Math.random()<0.5){
	      System.out.println("La pince du crabe vous manque de peu");
	    }
	    else{
	      System.out.println("Vous vous faites pincer l'orteille ! -7 PV");
	      p.modifierSante(-7);
	    }
	}
	public void reagirFuite(Personnage p) {}
}
