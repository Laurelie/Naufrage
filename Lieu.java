public class abstract Lieu{
  private Animal occupant;
  private String nom;
  public Lieu(String nom){
    this.nom = nom;
  }
  public abstract void choixAction();
  public abstract void genererAnimal();
  public abstract void decrireLieu();
  public void changerAnimal(Animal nouvelOccupant){
    occupant = nouvelOccupant;
  }
  public Animaux getOccupant(){
    return(occupant);
  }
  public String getNom(){
    return nom;
  }
}
