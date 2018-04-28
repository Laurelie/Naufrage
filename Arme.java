public abstract class Arme implements Stockable{
  private String nom;
  private int degat;
  private double precision;
  protected Arme( int degat, double precision, String nom){
    this.degat=degat;
    this.precision=precision;
    this.nom = nom;
  }
  public String getNom(){
    return(nom);
  }
  public double getPrecision(){
    return(precision);
  }
  public int getDegat(){
    return(degat);
  }
  public int getQuantite() {
	  return 1;
  }
  public void modifierQuantite(int n) {}
  public abstract void descriptionEchec();
  public abstract void descriptionReussite();
  public abstract Stockable clone();
  public String toString() {
	  return nom;
  }
}
