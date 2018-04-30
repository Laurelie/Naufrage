import java.util.ArrayList;
import java.util.Scanner;

public class Plage extends Lieu{
  Scanner sc = new Scanner(System.in);
  private ArrayList<Pechable> listePechable = new ArrayList<Pechable>();
  public Plage(){
    super("Plage");
  }
  public void choixAction(Personnage p){
  	System.out.println("1) Pecher\n2)Se balader");
  	int str = Integer.parseInt(sc.nextLine());
	while( str < 0 || str > 3){
	    System.out.println("Mauvaise selection. Recommencez.");
	    str = Integer.parseInt(sc.nextLine());
	}
    if(str==1){
		  p.pecher();
    }
    if(str==2)
      System.out.println("Pas encore fait ! C'est pour ramasser des crabes");
  }
  public void genererAnimal(){
  	listePechable.add(new Saumon());
  	listePechable.add(new Sardine());
  	listePechable.add(new Dorade());
    listePechable.add(new PoissonChat());
  	this.setPechable(listePechable);
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
