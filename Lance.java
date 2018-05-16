import java.util.ArrayList;

public class Lance extends Arme implements Fabricable{
   public Lance(){
      super(10,0.6,"Lance");
   }
    
   public ArrayList<Stockable> listeMateriaux(){
	   ArrayList<Stockable> liste = new ArrayList<Stockable>();
	   liste.add(new Bois(2));
	   liste.add(new Pierre(1));
	   return liste;
   }
   public int getPoids() {
	   return 300;
   }
   public Stockable clone() {
	   return new Lance();
   }
}
