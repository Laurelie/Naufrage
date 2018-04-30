import java.util.ArrayList;

public abstract class Lieu{
  private ArrayList<Construction> constructions = new ArrayList<Construction>();
  private AnimauxChassable occupant;
  private String nom;
  private ArrayList<Pechable> listePechable = new ArrayList<Pechable>();
  private ArrayList<Fruits> listeFruits = new ArrayList<Fruits>();
  protected Lieu(String nom){
    this.nom = nom;
    occupant = null;
  }
  public abstract void choixAction(Personnage p);

  public abstract void genererAnimal();
  public abstract void genererObjet();
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
  //plage
  public void setPechable(ArrayList<Pechable> listePechable){
    this.listePechable = listePechable;
  }
  public Pechable getPechable(int i){ //donner une position aleatoire dans listePechable
    if(i>=0 && i<listePechable.size())
      return listePechable.get(i);
    return null;
  }
  //fruits
  public void setFruits(ArrayList<Fruits> listeFruits){
    this.listeFruits = listeFruits;
  }
  public Fruits getFruits(int i){ //donner une position aleatoire dans listePechable
    if(i>=0 && i<listeFruits.size())
      return listeFruits.get(i);
    return null;
  }
}
