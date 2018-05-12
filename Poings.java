public class Poings extends Arme{
  public Poings(){
    super(1,1,"Poings");
    }
  public void descriptionEchec(){
    txt.textAffichage("Votre coup de poing passe à coté de l'animal.\n");
    }
  public void descriptionReussite(){
    txt.textAffichage("Vous assènez un sévère coup de poing à l'animal qui prend une blessure.\n");
    }
  public int getPoids() {
	  return 0;
  }
  public Stockable clone() {
	  return new Poings();
  }
}
