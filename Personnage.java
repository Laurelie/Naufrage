import java.util.ArrayList;

public class Personnage{
  private ArrayList<Lieu> carte = new ArrayLsit<Lieu>();
  private String nom;
  private ArrayList<? extends Stockage> inventaire = new ArrayList<? extends Stockage>();
  private int poidsIventaire; 
  private final int poidsMaxInventaire;
  private int energie;
  private int sante;
  private int x;
  private int y;
  public Personnage(String nom){
    poids = 0;
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
  public void ramasser(? extends Stockable objet){
    if (poidsInventaire+objet.getPoids() >= poidsMaxInventaire)
      System.out.println("Vous ne pouvez pas stocker cet objet ("+objet.getPoids()+") : "+poidsInventaire+"/"+poidsMaxInventaire)
    else{
      inventaire.add(objet);
      poidsInventaire += objet.getPoids();
    }
  }
  public ArrayList<? extends Stockage> getInventaire(){
    return inventaire;      
  }
  public void fabriquer(){
  
  }
  public void manger(){
  
  }
  public void combattre(){
  
  }
  public void fuir(){
  
  }
  public void pecher(){
  
  }
}
