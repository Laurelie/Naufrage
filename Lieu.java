public class abstract Lieu{
  private Animal occupant;
  private String nom;
  public Lieu(String nom){
    this.nom = nom;
  }
  public abstract void recolte();
  public abstract void genererAnimal();
  public void changerAnimal(Animal nouvelOccupant){
    occupant = nouvelOccupant;
  }
}
