import java.util.ArrayList;

public interface Fabricable extends Stockable{
  public abstract ArrayList<Stockable> listeMateriaux();
  public abstract String toString();
  public Stockable clone();
}
