import java.util.ArrayList;
import java.util.Scanner;

public class Personnage{
	Scanner sc = new Scanner(System.in);
	/*private ArrayList<Lieu> carte = new ArrayList<Lieu>(); Je pense que si on fait une seule map il vaut mieux l'instancier comme ca:*/
	private Lieu carte[][] = new Lieu[6][6];
	private String nom;
	/*private ArrayList<? extends Stockage> inventaire = new ArrayList<? extends Stockage>();
	Je pense que c'est plus simple pour consulter tes armes avant un combat ou pour choisir ce que tu veux manger, de faire plusieurs listes, comme ca on affiche juste la liste*/
	private ArrayList<Arme implements Stockable> equipement = new ArrayList<Arme>(2);
	private int nbEquipements;
	private final ArrayList<? implements Fabricable> listeFabrication = new ArrayList<? implements Fabricable>();
	private ArrayList<? implements Mangeable implements Stockable> aliments = new ArrayList<? implements Mangeable>();
	private ArrayList<Ressource> ressourcesNonComestibles = new ArrayList<Ressource>();
	private int poidsInventaire; 
	private /*final*/ int poidsMaxInventaire;/*augmentable en craftant sac a dos?*/
	private int energie;
	private int sante;
	private int x;
	private int y;
	public Personnage(String nom){
	Poings p = new Poings();
	equipement.add(p);
	equipement.add(null);
	for(int i=0;i<6;i++) {
		for(int j=0;j<6;j++) {
			carte[i][j] = new Foret();
		}
	}
    	this.nom = nom;
   	energie = 100;
    	sante = 100;
    	x=1;
    	y=1;
    	nbEquipements=0;
    	poidsInventaire =0;
    	poidsMaxInventaire=50;
	}
	public int getX() {
	 	return x;
	}
	public int getY() {
	 	return y;
	}
	public String getNom(){
	 	return nom;
	}
	public int getEnergie(){
	  	return energie;
	}
	public Lieu[][] getCarte(){
	  	return carte;
	}
	public void modifierEnergie(int nb){
	  	energie= energie+nb;
	  	if(energie<=0){
	    	System.out.println("\nVous vous évanouissez à cause de la fatigue.\n");
	    	/*Reste a definir ce que ca fait de s'evanouir*/
	    }
	}
	public int getSante(){
    	return sante;
 	}
	public void modifierSante(int nb){
	  	sante= sante+nb;
	  	if(sante<=0){
	    	System.out.println("\nVous êtes mort.... GAME OVER\n");}
	}
	public void afficherStatut(){ //LAU
		System.out.println("Vous êtes "+nom+"\nSanté: "+sante+"\nEnergie: "+energie+"\nVous avez "+nbEquipements+" équipements");
	}
	public void afficherInventaire(ArrayList<?> liste){ //LAU
		System.out.println("Voici votre inventaire :\n");
		for(int i=0; i<liste.size();i++){
			System.out.println((i+1)+") "+(liste.get(i)).toString());
		}
		System.out.println("");
	}
  public void jeterObjet(int i, int quantite, ArrayList<? implements Stockable> liste){
	  if(i<liste.size()){
		  if((liste.get(i)).getquantite()<quantite){
			  System.out.println("Vous avez moins de "+ quantite +" "+(liste.get(i)).toString());
		  }
		  if((liste.get(i)).getquantite()==quantite){
			  liste.remove(i);
		  }
		  else{
			  (liste.get(i)).modifierQuantite(-quantite);
		  }
	  }
  }
			  
		  
  public void ramasser(? implements Stockable objet){
    	if (poidsInventaire+objet.getPoids() >= poidsMaxInventaire)
      		System.out.println("Vous ne pouvez pas stocker cet objet ("+objet.getPoids()+") : "+poidsInventaire+"/"+poidsMaxInventaire)
    	else{
      		poidsInventaire += objet.getPoids();
	if (objet instance of Mangeable){
		for(int i =0; i<aliments.size();i++){
			if(((aliments.get(i)).toString()).equals(objet.toString())){
				nbAliments[i]++;
				return;
			}
		}
		aliments.add(objet);
		nbAliments.add(1);
	}
	if (objet instance of Ressources){
		for(int i =0; i<ressourcesNonComestibles.size();i++){
			if(((ressourcesNonComestibles.get(i)).toString()).equals(objet.toString())){
				nbRessources[i]++;
				return;
			}
		}
		ressourcesNonComestibles.add(objet);
		nbRessources.add(1);
	}
	if (objet instance of Arme){
		equipement.add(objet);
	}
	}
  }
	
  	public void seDeplacer(String direction){
    	if(direction.equals("Nord")){
      		y--;
    	}
    	if(direction.equals("Sud")){
      		y++;
    	}
	    if(direction.equals("Ouest")){
	      	x--;
	    }
	    if(direction.equals("Est")){
	      	x++;
	    }
	    carte[x][y].decrireLieu();
	    carte[x][y].genererAnimal();
  	}
    	public boolean estFabricable(objet implements Fabricable){
		boolean estFabricable = false;
		for(int i=0;i<(objet.listeMateriaux()).lenght();i++){
			for(int j = 0; j<aliments.size(); j++){
				if( (aliments.get(j)).toString()==((objet.listeMateriaux()).get(i)).toString() && nbAliments[j]>=(objet.quantiteMateriaux()).get(i)){
					estFabricable = true;
				}
			for(int k = 0; k<ressourcesNonComestibles.size(); k++){
				if( (ressourcesNonComestibles.get(k)).toString()==((objet.listeMateriaux()).get(i)).toString() && nbRessources[k]>=(objet.quantiteMateriaux()).get(i)){
					estFabricable = true;
				}
			if(! estFabricable){
				return false;
			}
			estFabricable = false;
		}
		return(true);
	}
				
			
			
 	public void fabriquer(){ //afficher les objets que l'on peut fabriquer et les matériaux à avoir pour le faire ? YEP
		
		for(int i = 0; i<listeFabrication.size(); i++){
			System.out.println(i+") "+(listeFabrication.get(i)).toString());
		}
		int str = Integer.parseInt(sc.nextLine());
		
			
					
					
  	}
  
  	public void manger(){ //LAU
	  	if (aliments.isEmpty())
	  		System.out.println("Vous n'avez rien à manger.");
	    else{
	    	this.afficherInventaire(aliments);
	    	System.out.println("Sélectionnez un aliment à manger");
	    	int str = Integer.parseInt(sc.nextLine());
	    	while( str < 0 || str > aliments.size()){
	    		System.out.println("Mauvaise séléction. Recommencez.");
	    		str = Integer.parseInt(sc.nextLine());
	    	}
	    	if (sante <= 100){
	      		sante += (aliments.get(str-1)).estMange(this); //le choix commence à 1
	      	}
	    }
 	}
  	public void combattre(){
	    Arme armeUtilisee;
	    if(equipement.get(1)==null){
	      System.out.println("Vous n'avez pas d'arme, vous attaquez donc avec vos poings.");
	      armeUtilisee = equipement.get(0);
	    }
	    else{
	      	System.out.println("Quelle arme voulez vous utiliser?");
	      	this.afficherInventaire(equipement);
	      	int str = Integer.parseInt(sc.nextLine());
	      	while( str < 0 || str > aliments.size()){
	    		System.out.println("Mauvaise séléction. Recommencez.");
	    		str = Integer.parseInt(sc.nextLine());
	    	}
	      	armeUtilisee = equipement.get(str-1); //le choix commence à 1
	    }
	    if((Math.random())<(armeUtilisee.getPrecision())){
	    	(carte[x][y].getOccupant()).perdSante(armeUtilisee.getDegat());
	      	armeUtilisee.descriptionReussite();
	      	if((carte[x][y].getOccupant()).getSante()<=0){
	        	(carte[x][y].getOccupant()).descriptionMort();
	        	//ramassage automatique
	        	if((carte[x][y].getOccupant()).getPoids() + poidsInventaire <= poidsMaxInventaire){
	        		System.out.println("Vous ramassez "+(carte[x][y].getOccupant()).toString());
	        		aliments.add(carte[x][y].getOccupant());
	        		poidsInventaire += (carte[x][y].getOccupant()).getPoids();
	        	}
	        	else
	        		System.out.println("Vous n'avez plus de place dans votre sac à aliments pour ramassez :"+carte[x][y].getOccupant());
	        	/*il faut alors ajouter l'animal a l'inventaire bouffe, mais est ce que les animaux ne font que de la nourriture???*/
	        	carte[x][y].changerAnimal(null); //animal mort : plus sur la case
	    }
	}
    	else
      		armeUtilisee.descriptionEchec();
    	if (carte[x][y].getOccupant() != null) //ajout de possibilité mort donc plus sur la case
    		(carte[x][y].getOccupant()).reagirAttaque(this);
	}

	public void fuir(){ //LAU
  		System.out.println("Vous essayez de fuir");
  		(carte[x][y].getOccupant()).reagirFuite(this);
  		carte[x][y].changerAnimal(null);
  	}
  
  	public void pecher(){
  	
  	}
}
