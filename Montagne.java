import java.util.ArrayList;
import java.util.Scanner;

public class Montagne extends Lieu{
  //private ArrayList<AnimauxChassable> listeAnimaux = new ArrayList<AnimauxChassable>();
  Scanner sc = new Scanner(System.in);
  public Montagne(){
    super("Montagne");
  }
  public void choixAction(Personnage p){
    System.out.println("1) Recuperer des minerais\n\n\tPressez 0 pour retour.\n");
    int str = Integer.parseInt(sc.nextLine());
  	while( str < 0 || str > 2){
  	    System.out.println("Mauvaise selection. Recommencez.");
  	    str = Integer.parseInt(sc.nextLine());
  	}
    if(str==0) return;
    if(str==1) p.miner();
  }
  public void genererAnimal(){
    if(Math.random()<0.5){
      this.changerAnimal(new Chamois());
      System.out.println("Vous apercevez un chamois au loin.");
    }
    //LE TOP ce serait de faire comme avec les poissons, faire un tableau d'animaux chassables puis tiré au sort SEULEMENT : PB dans combattre
    /*
  	listeAnimaux.add(new Chamois());
    this.setAnimaux;*/
  }
  public void genererObjet(){
    
  }
  public void decrireLieu(){
    System.out.println("Vous arrivez devant une montagne, vous levez la tete sans meme apercevoir le sommet.");
  }
}
