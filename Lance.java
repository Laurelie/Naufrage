public class Lance extends Arme{
   public Lance(){
      super(3,0.7,"Lance");
   }
    
   public void descriptionEchec(){
      System.out.println("Votre lance passe à coté de l'adversaire.");
   }
    
   public void descriptionReussite(){
      System.out.println("Vous touchez l'adversaire et vous lui infligez 3 blessures");
   }
}
