public abstract class AnimauxChassable extends Animaux implements Chassable {
	 private int sante;
	 protected AnimauxChassable(String nom, int poids, int rapportAlimentaire, int sante){
		 super(nom,poids,rapportAlimentaire);
		 this.sante = sante;
	 }
	 public int getSante(){
		    return sante;
		  }
	 public void perdSante(int nb){
		    sante=sante-nb;
		  }
}
