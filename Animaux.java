public class abstract Animaux implements mangeable{
  protected int poids;
  public Animaux(int poids){
    this.poids = poids;
  }
  public abstract int estMange();
  public int getPoids(){
    return poids;
  }
  public String toString(){
    return ;
  }
}
