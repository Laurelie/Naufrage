public class Lapin extends AnimauxChassable{
  	public Lapin(){
    	super("Lapin",(int)(Math.random()*20+10),20,(int)(Math.random()*10)+10);
  	}
  	public void reagirAttaque( Personnage p){
    	if(Math.random()<0.7){
      		System.out.println("Le lapin saute dans tous les sens sans vous effleurer");
    	}
    	else{
    		System.out.println("Vous vous faîtes mordre le pieds. Vous retire 3 PV");
      		p.modifierSante(-3);
    	}
  	}
  	public void reagirFuite(Personnage p) {
    	System.out.println("Le lapin lapine");
  	}
  	public void descriptionMort(){
     	System.out.println("Le lapin suffoque et meurt");
     	setVivant(false);
  	}
}
