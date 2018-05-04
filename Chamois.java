public class Chamois extends AnimauxChassable{
	public Chamois(){
		super("Chamois", 20, 20, 20);
	}
	public void reagirAttaque( Personnage p){
	    if(Math.random()<0.5){
	      System.out.println("Les cornes du chamois vous manque de peu");
	    }
	    else{
	      System.out.println("Vous vous faites renverser ! -15 PV");
	      p.modifierSante(-15);
	    }
	}
	public void reagirFuite(Personnage p) {
		
	}
}
