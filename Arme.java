public abstract class Arme{
  private String nom;
  private int degat;
  private float precision;
  protected Arme( int degat, float precision, String nom){
    this.degat=degat;
    this.precision=precision;
    this.nom = nom;
  }
  public String getNom(){
    return(nom);
  }
  public float getPrecision(){
    return(precision);
  }
  public int getDegat(){
    return(degat);
  }
  public void descriptionEchec();
  public void descriptionReussite();
 }
