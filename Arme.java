public abstract class Arme implements Stockable{
  protected Txt txt = new Txt();
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
  public void modifierQuantite(int n) {

  }
  public void descriptionEchec(){
    txt.textAffichage("Votre "+nom+" passe à coté de l'adversaire.\n");
  }
  public void descriptionReussite(){
    txt.textAffichage("Vous touchez l'adversaire et vous lui infligez "+degat+" blessures\n");
  }
  public String toString() {
	  return nom;
  }
}
