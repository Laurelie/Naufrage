public class Foret extends Lieu{
  public Foret(){
    super("Foret");
  }
  public void choixAction(){};
  public void genererAnimal(){
    if(Math.random<0.3){
      this.changerAnimal(new Ours());
    }
  }
  public void decrireLieu(){
    System.out.println("Vous avancer dans une foret dense.");
}
