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
    txt.textAffichage("1) Couper des arbres\n2) Ramasser des fruits\n");
    this.interagirConstruction(2);
    txt.textAffichage("\n\n\tPressez 0 pour retour.\n\n");
    int str = Integer.parseInt(sc.nextLine());
    while( str < 0 || str > 2+this.getConstructions().size()){
      txt.textAffichage("Mauvaise selection. Recommencez.\n");
      str = Integer.parseInt(sc.nextLine());
    }
    if(str==0) return;
    if(str==1) p.couperArbre();
    if(str==2) p.cueillir();
    if(str>2) this.getConstructions().get(str-3).interagir(p);
  }
  public void genererAnimal(){
    if(Math.random()<0.3){
      this.changerAnimal(new Ours());
      txt.textAffichage("Vous apercevez un ours derrière un buisson.\n");
    }
    else{
      this.changerAnimal(new Lapin());
      txt.textAffichage("Vous apercevez un lapin derrière un buisson.\n");
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
    listeFruits.add(new Cerise());
    this.setFruits(listeFruits);
  }

  public void decrireLieu(){
    txt.textAffichage("Vous avancer dans une foret dense.\n");
  }
}
