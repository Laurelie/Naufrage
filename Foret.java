import java.util.Scanner;

public class Foret extends Lieu{
  Scanner sc = new Scanner(System.in);
  public Foret(){
    super("Foret");
  }
  public void choixAction(Personnage p){
    System.out.println("1) Couper des arbres\n2) Ramasser des fruits");
    int str = Integer.parseInt(sc.nextLine());
    while( str < 0 || str > 3){
      System.out.println("Mauvaise selection. Recommencez.");
      str = Integer.parseInt(sc.nextLine());
    }
    if(str==1 || str==2)
      System.out.println("Pas encore fait !");
         
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
  }
  public void decrireLieu(){
    System.out.println("Vous avancer dans une foret dense.");
  }
}
