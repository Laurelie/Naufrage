import java.util.ArrayList;

public abstract class Lieu{
  private ArrayList<Construction> constructions = new ArrayList<Construction>();
  private AnimauxChassable occupant;
  private String nom;
  protected Lieu(String nom){
    this.nom = nom;
    occupant = null;
  }
  public abstract void choixAction();
  public abstract void genererAnimal();
  public abstract void decrireLieu();
  public String getSymbole(){
    return(nom.substring(0,2));
  }
  public void changerAnimal(AnimauxChassable nouvelOccupant){
    occupant = nouvelOccupant;
  }
  public AnimauxChassable getOccupant(){
    return(occupant);
  }
  public String getNom(){
    return nom;
  }
  public ArrayList<Construction> getConstructions(){
	  return constructions;
  }
}
