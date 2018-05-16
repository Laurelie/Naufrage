public class Poings extends Arme{
  public Poings(){
    super(3,0.85,"Poings");
    }
  public int getPoids() {
	  return 0;
  }
  public Stockable clone() {
	  return new Poings();
  }
}
