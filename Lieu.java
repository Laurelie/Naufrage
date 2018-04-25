public abstract class Lieu{
  private AnimauxChassable occupant;
  private String nom;
  protected Lieu(String nom){
    this.nom = nom;
    occupant = null;
  }
  public abstract void choixAction();
  public abstract void genererAnimal();
  public abstract void decrireLieu();
  public void changerAnimal(AnimauxChassable nouvelOccupant){
    occupant = nouvelOccupant;
  }
  public AnimauxChassable getOccupant(){
    return(occupant);
  }
  public String getNom(){
    return nom;
  }
}
