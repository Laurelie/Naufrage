public class Lapin extends AnimauxChassable{
  	public Lapin(){
    	     super("Lapin",(int)(Math.random()*8+15),(int)(Math.random()*3+15),2); 
          //nom poids rapportAlimentaire sante
  	}
  	public void reagirAttaque( Personnage p){
    	     if(Math.random()<0.7){
      	     reagirFuite(p);
          }
    	     else{
               int blessure = (int)(Math.random()*6+1);
    		     txt.textAffichage("Vous vous faîtes mordre le pieds. Vous retire "+blessure+" PV\n");
      	     p.modifierSante(-blessure);
    	     }
  	}
     public void reagirFuite(Personnage p){
          txt.textAffichage("Le lapin a peur de vous ! Il s'enfuit !\n");
     }
}
