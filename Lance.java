import java.util.ArrayList;

public class Lance extends Arme implements Fabricable{
   public Lance(){
      super(3,0.7,"Lance");
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
