public class Dorade extends Poissons{
	public Dorade(){
		super("Dorade",(int)(Math.random()*20+10),20);
	}
	public void reagirPeche( Personnage p){
    	if(Math.random()<0.5){
      		System.out.println("La "+super.toString()+" est mort quand vous le ramenez à bord");
    	}
    	else{
    		System.out.println(super.toString()+" vous arrache un doigt avant de mourir. Vous retire 10 PV");
      		p.modifierSante(-3);
    	}
  	}
}
