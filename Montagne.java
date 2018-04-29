import java.util.ArrayList;
import java.util.Scanner;

public class Montagne extends Lieu{
  Scanner sc = new Scanner(System.in);
  public Montagne(){
    super("Plage");
  }
  public void choixAction(Personnage p){
    System.out.println("1) Recuperer des minerais");
    int str = Integer.parseInt(sc.nextLine());
  	while( str < 0 || str > 2){
  	    System.out.println("Mauvaise selection. Recommencez.");
  	    str = Integer.parseInt(sc.nextLine());
  	}
    if(str==1)
  		System.out.println("Pas encore fait ! C'est pour ramasser les minerais");
  }
  public void genererAnimal(){
  	
  }
  public void decrireLieu(){
    System.out.println("Vous arrivez devant une montagne, vous levez la tete sans meme apercevoir le sommet.");
  }
}
