public abstract class Arme{
  private int degat;
  private float precision;
  protected Arme( int degat, float precision){
    this.degat=degat;
    this.precision=precision;
  }
  public void descriptionEchec();
  public void descriptionReussite();
 }
