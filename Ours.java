public class Ours extends Animaux implements /*Mangeable,*/ Chassable{  /*Animaux extend deja Mangeable, ca suffit non?*/
  public Ours(){
    super("Ours", 100, int(Math.random()*10+10));
  }
  public void reagirAttaque( Personnage p){
    if(Math.random()<0.8){
      System.out.println("La griffe de l'ours vous manque de peu");
    }
    else{
      System.out.println("Vous prenez un coup de patte dans l'abdomen qui vous retire 20 PV");
      p.modifierSante(-20);
    }
  }
  public void reagirFuite(Personnage p);
  public void descriptionMort(){
     System.out.println("L'ours s'effondre par terre, raide mort.");
  }
}
