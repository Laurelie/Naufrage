import java.util.ArrayList;

public abstract class Lieu extends Txt{
	protected Txt txt = new Txt();
	private ArrayList<Construction> constructions = new ArrayList<Construction>();
	private AnimauxChassable occupant;
	private String nom;
	private ArrayList<Pechable> listePechable = new ArrayList<Pechable>();
	private ArrayList<Fruits> listeFruits = new ArrayList<Fruits>();
	private boolean estConnu = false;
	//private ArrayList<AnimauxChassable> listeAnimaux = new ArrayList<AnimauxChassable>();
	protected Lieu(String nom){
		this.nom = nom;
		occupant = null;
	}
	public abstract void choixAction(Personnage p);

	public abstract void genererAnimal();
	public abstract void genererObjet();
	public abstract void decrireLieu();

	public String getSymbole(){
		if(this.estConnu()) {
			return(nom.substring(0,2));
		}
		return("In");
	}
	public void changerAnimal(AnimauxChassable nouvelOccupant){
		occupant = nouvelOccupant;
	}
	public AnimauxChassable getOccupant(){
		return(occupant);
	}
	
	public void interagirConstruction(int n) {
		for(int i =0;i<constructions.size();i++) {
			txt.textAffichage((i+n+1) + ") Interagir avec " + constructions.get(i).toString() + "\n");
		}
	}

//LE TOP ce serait de faire comme avec les poissons, faire un tableau d'animaux chassables puis tiré au sort SEULEMENT : PB dans combattre
/*
	public void setOccupant(ArrayList<AnimauxChassable> listeAnimaux){
			this.listeAnimaux = listeAnimaux;
	}
	public AnimauxChassable getOccupant(int i){
		if(i>=0 && i<listeAnimaux.size())
			return listeAnimaux.get(i);
		return null;
	}
	*/

	public String getNom(){
		return nom;
	}
	public ArrayList<Construction> getConstructions(){
		return constructions;
	}
	
	//plage
	public void setPechable(ArrayList<Pechable> listePechable){
		this.listePechable = listePechable;
	}
	public Pechable getPechable(){ //donner une position aleatoire dans listePechable
		int i = (int)(Math.random()*listePechable.size());
		return listePechable.get(i);
	}

	//fruits
	public void setFruits(ArrayList<Fruits> listeFruits){
		this.listeFruits = listeFruits;
	}
	public Fruits getFruits(){ //donner une position aleatoire dans listeFruit
		int i = (int)(Math.random()*listeFruits.size());
		return listeFruits.get(i);
	}

	public boolean estConnu() {
		return estConnu;
	}
	public void decouvrir() {
		estConnu = true;
	}
}
