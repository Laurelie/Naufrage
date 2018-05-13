import java.util.ArrayList;
import java.util.Scanner;

public class Montagne extends Lieu{
  //private ArrayList<AnimauxChassable> listeAnimaux = new ArrayList<AnimauxChassable>();
  Scanner sc = new Scanner(System.in);
  public Montagne(){
    super("Montagne");
  }
  public void choixAction(Personnage p){
    txt.textAffichage("1) Recuperer des minerais\n");
    this.interagirConstruction(1);
    txt.textAffichage("\n\n\tPressez 0 pour retour.\n\n");
    int str = Integer.parseInt(sc.nextLine());
  	while( str < 0 || str > 1+this.getConstructions().size()){
  	    txt.textAffichage("Mauvaise selection. Recommencez.\n");
  	    str = Integer.parseInt(sc.nextLine());
  	}
    if(str==0) return;
    if(str==1) p.miner();
    if(str>1) {
    	this.getConstructions().get(str-2).interagir(p);
    }
         
  }
  public void genererAnimal(){
    if(Math.random()<0.5){
      this.changerAnimal(new Chamois());
      txt.textAffichage("Vous apercevez un chamois au loin.\n");
    }
    //LE TOP ce serait de faire comme avec les poissons, faire un tableau d'animaux chassables puis tiré au sort SEULEMENT : PB dans combattre
    /*
  	listeAnimaux.add(new Chamois());
    this.setAnimaux;*/
  }
  public void genererObjet(){
    
  }
  public void decrireLieu(){
    txt.textAffichage("Vous arrivez devant une montagne, vous levez la tete sans meme apercevoir le sommet.\n");
  }
}
