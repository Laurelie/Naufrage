public class Lapin extends AnimauxChassable{
  	public Lapin(){
    	super("Lapin",25,20,2);
  	}
  	public void reagirAttaque( Personnage p){
    	if(Math.random()<0.7){
      		txt.textAffichage("Le lapin saute dans tous les sens sans vous effleurer\n");
    	}
    	else{
    		txt.textAffichage("Vous vous faîtes mordre le pieds. Vous retire 3 PV\n");
      		p.modifierSante(-3);
    	}
  	}
}
