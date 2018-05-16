import java.util.ArrayList;

public class Hache extends Arme implements Fabricable{
   public Hache(){
      super(20,0.7,"Hache");
   }
    
   public ArrayList<Stockable> listeMateriaux(){
	   ArrayList<Stockable> liste = new ArrayList<Stockable>();
	   liste.add(new Bois(3));
	   liste.add(new Pierre(5));
	   return liste;
   }
   public int getPoids() {
	   return 400;
   }
   public Stockable clone() {
	   return new Hache();
   }
}
