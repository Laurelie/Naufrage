import java.util.ArrayList;
import java.util.Scanner;

public class Plage extends Lieu{
  Scanner sc = new Scanner(System.in);
  //private ArrayList<AnimauxChassable> listeAnimaux = new ArrayList<AnimauxChassable>();
  private ArrayList<Pechable> listePechable = new ArrayList<Pechable>();
  public Plage(){
    super("Plage");
  }
  public void choixAction(Personnage p){
  	txt.textAffichage("1) Pecher\n\n\tPressez 0 pour retour.\n\n");
  	int str = Integer.parseInt(sc.nextLine());
	  while( str < 0 || str > 3){
	    txt.textAffichage("Mauvaise selection. Recommencez.\n");
	    str = Integer.parseInt(sc.nextLine());
	  }
    if(str==0) return;
    if(str==1) p.pecher();
  }
  public void genererAnimal(){
    //dans l'eau
  	listePechable.add(new Saumon());
  	listePechable.add(new Sardine());
  	listePechable.add(new Dorade());
    listePechable.add(new PoissonChat());
  	this.setPechable(listePechable);
    //sur le sable
    if(Math.random()<0.5){
      this.changerAnimal(new Crabe());
      txt.textAffichage("Vous apercevez un crabe au bord de l'eau.\n");
    }

    //LE TOP ce serait de faire comme avec les poissons, faire un tableau d'animaux chassables puis tiré au sort SEULEMENT : PB dans combattre
        //sur le sable
    /*listeAnimaux.add(new Crabe());
    this.setAnimaux(listeAnimaux);*/
  }

  public void genererObjet(){
    listePechable.add(new Coquillage());
    listePechable.add(new Bouteille());
    listePechable.add(new Lunettes());
    this.setPechable(listePechable);
  }

  public void decrireLieu(){
    txt.textAffichage("Vous sentez la douceur du sable sous vos pieds. Vous relevez la tete : la plage...la mer.\n");
  }
}