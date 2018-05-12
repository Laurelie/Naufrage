public class Lapin extends AnimauxChassable{
  	public Lapin(){
    	super("Lapin",(int)(Math.random()*20+10),20,(int)(Math.random()*10)+10);
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
