import java.util.ArrayList;

public class Personnage{
  private String nom;
  private ArrayList<? extends Stockage> inventaire = new ArrayList<? extends Stockage>();
  private int energie;
  private int sante;
  private int x;
  private int y;
  public Personnage(String nom){
    this.nom = nom;
    energie = 100;
    sante = 100;
    x=0;
    y=0;
  }
  public String getNom(){
    return nom;
  }
  public int getEnergie(){
    return energie;
  }
  public int getSante(){
    return sante;
  }
  public ArrayList<????????> getInventaire(){
    for
  }
  public void fabriquer(){}
  public void manger(){}
  public void combattre(){}
  public void fuir(){}
  public void pecher(){}
  public void ramasser(){}
}
