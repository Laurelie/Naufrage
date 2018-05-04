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
  	System.out.println("1) Pecher\n2)Se balader\n\n\tPressez 0 pour retour.\n");
  	int str = Integer.parseInt(sc.nextLine());
	  while( str < 0 || str > 3){
	    System.out.println("Mauvaise selection. Recommencez.");
	    str = Integer.parseInt(sc.nextLine());
	  }
    if(str==0) return;
    if(str==1) p.pecher();
    if(str==2) System.out.println("Pas encore fait ! C'est pour ramasser des crabes"); // ? Necessaire ?
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
      System.out.println("Vous apercevez un crabe au bord de l'eau.");
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
    System.out.println("Vous sentez la douceur du sable sous vos pieds. Vous relevez la tete : la plage...la mer.");
  }
}