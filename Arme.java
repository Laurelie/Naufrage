public abstract class Arme{
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
  public abstract void descriptionEchec();
  public abstract void descriptionReussite();
}
