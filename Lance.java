import java.util.ArrayList;

public class Lance extends Arme implements Fabricable{
   public Lance(){
      super(3,0.7,"Lance");
   }
    
   public void descriptionEchec(){
      System.out.println("Votre lance passe à coté de l'adversaire.");
   }
    
   public void descriptionReussite(){
      System.out.println("Vous touchez l'adversaire et vous lui infligez 3 blessures");
   }
   public ArrayList<Stockable> listeMateriaux(){
	   ArrayList<Stockable> liste = new ArrayList<Stockable>();
	   liste.add(new Bois(2));
	   liste.add(new Pierre(1));
	   return liste;
   }
   public int getPoids() {
	   return(500);
   }
   public Stockable clone() {
	   return new Lance();
   }
}
