public class abstract Animaux implements mangeable{
  protected int poids;
  protected String nom;
  private int rapportAlimentaire;
  public Animaux(String nom, int poids, int rapportAlimentaire){
    this.poids = poids;
    this.nom = nom;
    this.rapportAlimentaire = rapportAlimentaire;
  }
  public int getPoids(){
    return poids;
  }
  public String toString(){
    return "C'est un "+nom+" de poids :"+poids+" qui équivault à "+rapportAlimentaire+" de rapportAlimentaire";
  }
  public abstract int estMange();
}
