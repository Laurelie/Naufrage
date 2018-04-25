import java.util.ArrayList;
import java.util.Scanner;

public class Personnage{
  Scanner sc = new Scanner(System.in);
  /*private ArrayList<Lieu> carte = new ArrayList<Lieu>(); Je pense que si on fait une seule map il vaut mieux l'instancier comme ca:*/
  private Lieu carte[][] = new Lieu[6][6];
  private String nom;
  /*private ArrayList<? extends Stockage> inventaire = new ArrayList<? extends Stockage>();
  Je pense que c'est plus simple pour consulter tes armes avant un combat ou pour choisir ce que tu veux manger, de faire plusieurs listes, comme ca on affiche juste la liste*/
  private ArrayList<Arme> equipement = new ArrayList<Arme>(2);
  private int nbEquipements=0;
  private int poidsIventaire; 
  private /*final*/ int poidsMaxInventaire;/*augmentable en craftant sac a dos?*/
  private int energie;
  private int sante;
  private int x;
  private int y;
  public Personnage(String nom){
	Poings p = new Poings();
	equipement.add(p);
	equipement.add(null);
	for(int i=0;i<6;i++) {
		for(int j=0;j<6;j++) {
		carte[i][j] = new Foret();
	}}
    this.nom = nom;
    energie = 100;
    sante = 100;
    x=1;
    y=1;
  }
  public int getX() {
	  return x;
  }
  public int getY() {
	  return y;
  }
  public String getNom(){
    return nom;
  }
  public int getEnergie(){
    return energie;
  }
  public Lieu[][] getCarte(){
    return carte;
  }
  public void modifierEnergie(int nb){
    energie= energie+nb;
    if(energie<=0){
      System.out.println("Vous vous évanouissez à cause de la fatigue.");
      /*Reste a definir ce que ca fait de s'evanouir*/}
  }
  public int getSante(){
    return sante;
  }
  public void modifierSante(int nb){
    sante= sante+nb;
    if(sante<=0){
      System.out.println("Vous êtes mort.... GAME OVER");}
      /*arretez le jeu*/
  }
  public void afficherstatut(){
    System.out.println("Santé: "+sante+"\nEnergie: "+energie);
  }
    
 /* public void ramasser(? extends Stockable objet){
    if (poidsInventaire+objet.getPoids() >= poidsMaxInventaire)
      System.out.println("Vous ne pouvez pas stocker cet objet ("+objet.getPoids()+") : "+poidsInventaire+"/"+poidsMaxInventaire)
    else{
      inventaire.add(objet);
      poidsInventaire += objet.getPoids();
    }
  }
  public ArrayList<? extends Stockage> getInventaire(){
    return inventaire;      
  }*/
    
  public void seDeplacer(String direction){
    if(direction.equals("Nord")){
      y--;
    }
    if(direction.equals("Sud")){
      y++;
    }
    if(direction.equals("Ouest")){
      x--;
    }
    if(direction.equals("Est")){
      x++;
    }
    carte[x][y].decrireLieu();
    carte[x][y].genererAnimal();
  }
    
  /*public void fabriquer(){
  
  }*/
  public void manger(/*? extends Mangeable objet*/){}
    /*if (sante <= 100)
      sante += objet.estMange();
  }*/
  public void combattre(){
    Arme armeUtilisee;
    if(equipement.get(1)==null){
      System.out.println("Vous n'avez pas d'arme, vous attaquez donc avec vos poings.");
      armeUtilisee = equipement.get(0);
    }
    else{
      System.out.println("Quelle arme voulez vous utiliser?");
      for(int i=1;i<=nbEquipements;i++){
        System.out.println(i+") "+equipement.get(i).getNom());
      }
      String choix = sc.nextLine();
      armeUtilisee = equipement.get(Integer.parseInt(choix));
    }
    if((Math.random())<(armeUtilisee.getPrecision())){
      (carte[x][y].getOccupant()).perdSante(armeUtilisee.getDegat());
      armeUtilisee.descriptionReussite();
      if((carte[x][y].getOccupant()).getSante()<=0){
        (carte[x][y].getOccupant()).descriptionMort();
        /*il faut alors ajouter l'animal a l'inventaire bouffe, mais est ce que les animaux ne font que de la nourriture???*/
      }
    }
    else{
      armeUtilisee.descriptionEchec();
    }
    (carte[x][y].getOccupant()).reagirAttaque(this);
  }
  public void fuir(){
  
  }
  public void pecher(){
  
  }
  public void ignorer() {
  }
}
