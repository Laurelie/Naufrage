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
	public void afficherCarte(){
		String ligne;
		for(int i=0;i<carte.lenght();i++){
			ligne = "";
			for(int j = 0;j<carte[i].lenght;j++){
				ligne+= "  " +(carte[i][j]).getSymbole();
			}
			System.out.println(ligne);
		}
		System.out.println("Montagne = Mo");
		System.out.println("Foret = Fo");
		System.out.println("Mer = Me");
		System.out.println("Plage = Pl");
	}
	public void afficherListe(ArrayList<?> liste){ //LAU
		System.out.println("Voici votre inventaire :\n");
		for(int i=0; i<liste.size();i++){
			System.out.println((i+1)+") "+(liste.get(i)).toString())+ "  x "+(liste.get(i)).getQuantite());
		}
		System.out.println("");
	}
	
	public void consulterInventaire(){
		System.out.println("Que voulez vous consulter? \n 1) Besace à nouriture \n 2) Sacoche à ressources \n 3) Equipement \n 4) Constructions ");
		int str = Integer.parseInt(sc.nextLine());
		if(str == 1){
			afficherListe(aliments);
		}
		if(str == 2){
			afficherListe(ressourcesNonComestibles);
		}
		if(str == 3){
			afficherListe(equipement);
		}
		if(str == 4){
			
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
		  poidsInventaire =- quantite*((liste.get(i)).getPoids());
	  }
  }

  public void jeter(){
	  
		  
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
		System.out.println("Que voulez vous fabriquer?");
		for(int i = 0; i<listeFabrication.size(); i++){
			System.out.println((i+1)"- "+(listeFabrication.get(i)).toString())
			this.afficherListe(listeFabrication.get(i).listeMateriaux());
		}
		int str = Integer.parseInt(sc.nextLine());
		if(!(listeFabrication.get(i)).estFabricable()){
			System.out.println("Vous n'avez pas suffisement de ressources pour fabriquer cela.")
		}
		else{
			if(listeFabrication.get(str) instance of Construction){
				
			}
			else{
				this.ramasser(listeFabrication.get(i));
			}
			for(int i=0;i<((listeFabrication.get(i)).listeMateriaux()).lenght();i++){
				for(int j = 0; j<aliments.size(); j++){
					if( (aliments.get(j)).toString()==(((listeFabrication.get(i)).listeMateriaux()).get(i)).toString())){
						this.jeterObjet(j,(listeFabrication.get(i)).listeMateriaux().getQuantite(),aliments);
				}
				for(int k = 0; k<ressourcesNonComestibles.size(); k++){
					if( (ressourcesNonComestibles.get(k)).toString()==(((listeFabrication.get(i)).listeMateriaux()).get(i)).toString()))){
						this.jeterObjet(j,(listeFabrication.get(i)).listeMateriaux().getQuantite(),aliments);
				}
			}
		}						
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
	      	while( str < 0 || str > equipement.size()){
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
	        	p.ramasser(carte[x][y].getOccupant());
	        	(carte[x][y].getOccupant()) == null;
		}
	}
    	else
      		armeUtilisee.descriptionEchec();
    	if (carte[x][y].getOccupant() != null){ //ajout de possibilité mort donc plus sur la case
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
