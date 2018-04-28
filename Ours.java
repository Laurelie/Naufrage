public class Ours extends AnimauxChassable{
  public Ours(){
    super("Ours", 100, 80, (int)(Math.random()*10)+10);
  }
  public void reagirAttaque( Personnage p){
    if(Math.random()<0.2){
      System.out.println("La griffe de l'ours vous manque de peu");
    }
    else{
      System.out.println("Vous prenez un coup de patte dans l'abdomen qui vous retire 20 PV");
      p.modifierSante(-20);
    }
  }
  public void reagirFuite(Personnage p) { //LAU
  	if(Math.random()<0.5){
      System.out.println("L'ours vous voit : il vous court après");
      this.reagirAttaque(p);
    }
    else{
      System.out.println("L'ours mange du miel, il ne vous voit pas");
    }
  }
  public void descriptionMort(){
     System.out.println("L'ours s'effondre par terre, raide mort.");
     setVivant(false);
  }

}
