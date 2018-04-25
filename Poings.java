public class Poings extends Arme{
  public Poings(){
    super(1,1,"Poings");
    }
  public void descriptionEchec(){
    System.out.println("Votre coup de poing passe à coté de l'animal.");
    }
  public void descriptionReussite(){
    System.out.println("Vous assènez un sévère coup de poing à l'animal qui prend une blessure.");
    }
}
