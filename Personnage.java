import java.util.ArrayList;
import java.util.Scanner;

public class Personnage{
  Scanner sc = new Scanner(System.in);
  /*private ArrayList<Lieu> carte = new ArrayList<Lieu>(); Je pense que si on fait une seule map il vaut mieux l'instancier comme ca:*/
  private Lieu[][] carte = Lieu[6][6];
  private String nom;
  /*private ArrayList<? extends Stockage> inventaire = new ArrayList<? extends Stockage>();
  Je pense que c'est plus simple pour consulter tes armes avant un combat ou pour choisir ce que tu veux manger, de faire plusieurs listes, comme ca on affiche juste la liste*/
  private ArrayList<Arme> equipement = new ArrayList<Arme>();
  private int nbEquipements=0;
  equipement.add(new Poing());
  private int poidsIventaire; 
  private /*final*/ int poidsMaxInventaire;/*augmentable en craftant sac a dos?*/
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
  public void modifierEnergie(int nb){
    energie= energie+nb;
    if(energie<=0){
      System.out.println("Vous vous évanouissez à cause de la fatigue.");
      /*Reste a definir ce que ca fait de s'evanouir*/
  }
  public int getSante(){
    return sante;
  }
  public void modifierSante(int nb){
    sante= sante+nb;
    if(sante<=0){
      System.out.println("Vous êtes mort.... GAME OVER");
      /*arretez le jeu*/
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
  public void manger(? extends Mangeable objet){
    if (sante <= 100)
      sante += objet.estMange();
  }
  public void combattre(Animaux animal){
    Arme armeUtilisee;
    if(equipement[1]==null){
      System.out.println("Vous n'avez pas d'arme, vous attaquez donc avec vos poings.");
      armeUtilisee = equipement[0];
    }
    else{
      System.out.println("Quelle arme voulez vous utiliser?");
      for(int i=1;i++;i<=nbEquipements){
        System.out.println(i+") "+equipement[i].getNom());
      }
      int choix = sc.nextLine();
      armeUtilisee = equipement[choix];
    }
    if(Math.random()<armeUtilisee.getPrecision()){
      animal.perdSanté(armeUtilisee.getDegat());
      armeUtilisee.descriptionReussite();
      if(animal.getSante()<=0){
        animal.descriptionMort();
        /*il faut alors ajouter l'animal a l'inventaire bouffe, mais est ce que les animaux ne font que de la nourriture???*/
      }
    }
    else{
      armeUtilisee.descriptionEchec();
    }
    animal.reagirAttaque(this);
  }
  public void fuir(){
  
  }
  public void pecher(){
  
  }
}
