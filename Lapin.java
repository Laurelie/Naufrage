public class Lapin extends Animaux implements Mangeable, Chassable{
  private boolean vivant;
  private boolean cru;
  public Lapin(){
    int poids = (int)(Math.random()*20+10); //poidsMax = 30
    int rapportAlimentaire = poids*20/30; //20 de rapportAlim si poids = 30
    super("Lapin",poids,rapportAlimentaire);
    vivant = True;
    cru = True;
  }
  public void estCuisine(){
    if (!vivant){ //vivant == False
      cru = False
    }
    else
      System.out.println("On ne peut pas cuisiné un Lapin vivant");
  }
  public int estMange(){
    if (cru){
      System.out.println("Vous mangez un lapin cru : -"+rapportAlimentaire+" de santé");
      return rapportAlimentaire;
    }
    else{
      System.out.println("Vous mangez un lapin cuisiné : +"+rapportAlimentaire+" de santé");
    }
  }
  public String toString(){
    String txt =super.toString();
    if(vivant)
      return txt+"Il est vivant."
    if(cru)
      return txt+"Il est mort et cru."
    return txt+"Il est mort et cuisiné";
  }
}
