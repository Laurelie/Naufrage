import java.util.ArrayList;
import java.util.Scanner;

public class Foret extends Lieu{
  Scanner sc = new Scanner(System.in);
  private ArrayList<Fruits> listeFruits = new ArrayList<Fruits>();
  private ArrayList<Pechable> listePechable = new ArrayList<Pechable>();
  //private ArrayList<AnimauxChassable> listeAnimaux = new ArrayList<AnimauxChassable>();
  public Foret(){
    super("Foret");
  }
  public void choixAction(Personnage p){
    System.out.println("1) Couper des arbres\n2) Ramasser des fruits\n\n\tPressez 0 pour retour.\n");
    int str = Integer.parseInt(sc.nextLine());
    while( str < 0 || str > 3){
      System.out.println("Mauvaise selection. Recommencez.");
      str = Integer.parseInt(sc.nextLine());
    }
    if(str==0) return;
    if(str==1) p.couperArbre();
    if(str==2) p.cueillir();
         
  }
  public void genererAnimal(){
    if(Math.random()<0.3){
      this.changerAnimal(new Ours());
      System.out.println("Vous apercevez un ours derrière un buisson.");
    }
    else{
      this.changerAnimal(new Lapin());
      System.out.println("Vous apercevez un lapin derrière un buisson.");
    }
    //LE TOP ce serait de faire comme avec les poissons, faire un tableau d'animaux chassables puis tiré au sort SEULEMENT : PB dans combattre
    /*
    listeAnimaux.add(new Ours());
    listeAnimaux.add(new Lapin());
    this.setOccupant(listeAnimaux);
    */
  }

  public void genererObjet(){
    listeFruits.add(new Pomme());
    listeFruits.add(new Baies());
    this.setFruits(listeFruits);
  }

  public void decrireLieu(){
    System.out.println("Vous avancer dans une foret dense.");
  }
}
