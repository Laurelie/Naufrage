import java.util.ArrayList;
import java.util.Scanner;

public class Personnage{
	Scanner sc = new Scanner(System.in);
	/*private ArrayList<Lieu> carte = new ArrayList<Lieu>(); Je pense que si on fait une seule map il vaut mieux l'instancier comme ca:*/
	private Lieu carte[][] = new Lieu[6][6];
	private String nom;
	/*private ArrayList<? extends Stockage> inventaire = new ArrayList<? extends Stockage>();
	Je pense que c'est plus simple pour consulter tes armes avant un combat ou pour choisir ce que tu veux manger, de faire plusieurs listes, comme ca on affiche juste la liste*/
	private ArrayList<Stockable> equipement = new ArrayList<Stockable>(2);
	private final ArrayList<Fabricable> listeFabrication = new ArrayList<Fabricable>();
	private ArrayList<Stockable> aliments = new ArrayList<Stockable>();
	private ArrayList<Stockable> ressourcesNonComestibles = new ArrayList<Stockable>();
	private int poidsInventaire; 
	private /*final*/ int poidsMaxInventaire;/*augmentable en craftant sac a dos?*/
	private int energie;
	private int sante;
	private int date = 1;
	private final int nbMaxCamps = 2;
	private int x;
	private int y;
	public Personnage(String nom){
	Poings p = new Poings();
	equipement.add(p);
	listeFabrication.add(new Lance());
	listeFabrication.add(new Camp());
	for(int i=0;i<6;i++) {
		for(int j=0;j<6;j++) {
			if(i==0 || i==5 || j==0 || j==5) {
				carte[i][j]= new Mer();
			}
			else {
				carte[i][j] = new Foret();
			}
		}
	}
    	this.nom = nom;
   	energie = 100;
    	sante = 100;
    	x=1;
    	y=1;
    	poidsInventaire =0;
    	poidsMaxInventaire=1500;
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
		System.out.println("Vous êtes "+nom+"\nSanté: "+sante+"\nEnergie: "+energie+"\nVous portez "+poidsInventaire+" pds /" +poidsMaxInventaire+ "pds");
	}
	public void afficherCarte(){
		String ligne;
		for(int i=0;i<carte.length;i++){
			ligne = "";
			for(int j = 0;j<carte[i].length;j++){
				if(x==i && y==j) {
					ligne+= "  X";
				}
				else {
					if(carte[i][j].getConstructions().size()!=0) {
						ligne+= "  Ca";
					}
					else {
						ligne+= "  " +(carte[i][j]).getSymbole();
					}
				}
			}
			System.out.println(ligne);
		}
		System.out.println("Montagne = Mo");
		System.out.println("Foret = Fo");
		System.out.println("Mer = Me");
		System.out.println("Plage = Pl");
		System.out.println("Votre position = X");
		System.out.println("Camp = Ca");
	}
	public void afficherListe(ArrayList<Stockable> liste){ //LAU
		for(int i=0; i<liste.size();i++){
			if(liste.get(i)!=null) {
				System.out.println((i+1)+") "+(liste.get(i)).toString()+ "  x "+(liste.get(i)).getQuantite());
			}
		}
		System.out.println("");
	}
	
	public void consulterInventaire(){
		System.out.println("Que voulez vous consulter? \n 1) Besace à nouriture \n 2) Sacoche à ressources \n 3) Equipement \n 4) Constructions ");
		int str = Integer.parseInt(sc.nextLine());
		while(str<0 || str>4){
			System.out.println("Commande invalide");
			System.out.println("Que voulez vous consulter? \n 1) Besace à nouriture \n 2) Sacoche à ressources \n 3) Equipement \n 4) Constructions ");
			str = Integer.parseInt(sc.nextLine());
		}
		if(str == 1){
			System.out.println("Sélectionner un élément pour le jeter, sélectionner 0) pour ne rien jeter.");
			this.afficherListe(aliments);
			str = Integer.parseInt(sc.nextLine());
			while(str<0 || str>aliments.size()){
				System.out.println("Commande invalide");
				System.out.println("Sélectionner un élément pour le jeter, sélectionner 0) pour ne rien jeter.");
				str = Integer.parseInt(sc.nextLine());
			}
			if (str==0) return;
			System.out.println("Combien voulez vous en jeter?");
			int quantite = Integer.parseInt(sc.nextLine());
			this.jeterObjet(str-1,quantite,aliments);
			return;
		}
		if(str == 2){
			System.out.println("Sélectionner un élément pour le jeter, sélectionner 0) pour ne rien jeter.");
			afficherListe(ressourcesNonComestibles);
			str = Integer.parseInt(sc.nextLine());
			while(str<0 || str>ressourcesNonComestibles.size()){
				System.out.println("Commande invalide");
				System.out.println("Sélectionner un élément pour le jeter, sélectionner 0) pour ne rien jeter.");
				str = Integer.parseInt(sc.nextLine());
			}
			if(str==0) return;
			System.out.println("Combien voulez vous en jeter?");
			int quantite = Integer.parseInt(sc.nextLine());
			jeterObjet(str-1,quantite,ressourcesNonComestibles);
			return;
		}
		if(str == 3){
			System.out.println("Sélectionner un élément pour le jeter, sélectionner 0) pour ne rien jeter.");
			this.afficherListe(equipement);
			str = Integer.parseInt(sc.nextLine());
			while(str<0 || str>equipement.size()){
				System.out.println("Commande invalide");
				System.out.println("Sélectionner un élément pour le jeter, sélectionner 0) pour ne rien jeter.");
				str = Integer.parseInt(sc.nextLine());
			}
			if(str == 0) return;
			jeterObjet(str-1,1,equipement);
			return;
		}
		/*if(str == 4){
			afficherListe(constructions);
		}*/
}
			
  public void jeterObjet(int i, int quantite, ArrayList<Stockable> liste){
	  if(i<liste.size()){
		  if((liste.get(i)).getQuantite()<quantite){
			  System.out.println("Vous avez moins de "+ quantite +" "+(liste.get(i)).toString());
		  }
		  if((liste.get(i)).getQuantite()==quantite){
			  liste.remove(i);
		  }
		  else{
			  (liste.get(i)).modifierQuantite(-quantite);
		  }
		  poidsInventaire =- quantite*((liste.get(i)).getPoids());
	  }
  }
	  
  public void ramasser(Stockable objet){
    	if (poidsInventaire+objet.getPoids() >= poidsMaxInventaire)
      		System.out.println("Vous ne pouvez pas stocker cet objet (il p�se: "+objet.getPoids()+") et vous portez deja :"+poidsInventaire+"/"+poidsMaxInventaire);
    	else{
      		poidsInventaire += objet.getPoids();
	if (objet instanceof Mangeable){
		for(int i =0; i<aliments.size();i++){
			if(((aliments.get(i)).toString()).equals(objet.toString())){
				(aliments.get(i)).modifierQuantite(objet.getQuantite());
				return;
			}
		}
		aliments.add((Mangeable)objet);
		return;
	}

	if (objet instanceof Arme){
		equipement.add((Arme)objet);
		return;
	}
	for(int i =0; i<ressourcesNonComestibles.size();i++){
		if(((ressourcesNonComestibles.get(i)).toString()).equals(objet.toString())){
			ressourcesNonComestibles.get(i).modifierQuantite(objet.getQuantite());;
			return;
		}
	}
	ressourcesNonComestibles.add(objet);
	}
  }
	
  	public void seDeplacer(String direction){
    	if(direction.equals("Nord")){
      		x--;
    	}
    	if(direction.equals("Sud")){
      		x++;
    	}
	    if(direction.equals("Ouest")){
	      	y--;
	    }
	    if(direction.equals("Est")){
	      	y++;
	    }
	    if(carte[x][y].getConstructions().size()!= 0) {
	    	System.out.println("Vous arrivez dans un de vos camps");
	    }
	    else {
	    	carte[x][y].decrireLieu();
	    }
	    carte[x][y].genererAnimal();
  	}
    public boolean estFabricable(Fabricable objet){
		boolean estFabricable = false;
		if(objet instanceof Construction) {
			if(!objet.toString().equals("Camp") && carte[x][y].getConstructions().size()==0) {
				System.out.println("Vous devez d'abord construire un camp");
				return false;
			}
			for(int k=0;k<carte[x][y].getConstructions().size();k++) {
				if(objet.toString().equals(carte[x][y].getConstructions().get(k).toString())){
					System.out.println("Vous avez d�j� construit cet objet dans cette zone");
					return false;
				}
			}
			if(objet.toString().equals("Camp")) {
				if(Camp.getNbCamps()>=nbMaxCamps) {
					return false;
				}
			}
			
		}
		for(int i=0;i<(objet.listeMateriaux()).size();i++){
			for(int j = 0; j<aliments.size(); j++){
				if( (aliments.get(j)).toString()==((objet.listeMateriaux()).get(i)).toString() && aliments.get(j).getQuantite()>=(objet.listeMateriaux()).get(i).getQuantite()){
					estFabricable = true;
				}
			}
			for(int k = 0; k<ressourcesNonComestibles.size(); k++){
				if( (ressourcesNonComestibles.get(k)).toString()==((objet.listeMateriaux()).get(i)).toString() && ressourcesNonComestibles.get(k).getQuantite()>=(objet.listeMateriaux()).get(i).getQuantite()){
					estFabricable = true;
				}
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
			System.out.println((i+1)+"- "+(listeFabrication.get(i)).toString());
			this.afficherListe(listeFabrication.get(i).listeMateriaux());
		}
		int str = Integer.parseInt(sc.nextLine());
		if(!this.estFabricable(listeFabrication.get(str-1))){
			System.out.println("Vous n'avez pas suffisement de ressources pour fabriquer cela.");
		}
		else{
			if(listeFabrication.get(str-1) instanceof Construction){
				carte[x][y].getConstructions().add((Construction)listeFabrication.get(str-1).clone());
			}
			else{
				this.ramasser(listeFabrication.get(str-1).clone());
			}
			for(int i=0;i<((listeFabrication.get(str-1)).listeMateriaux()).size();i++){
				for(int j = 0; j<aliments.size(); j++){
					if( (aliments.get(j)).toString()==(((listeFabrication.get(str-1)).listeMateriaux()).get(i)).toString()){
						this.jeterObjet(j,(listeFabrication.get(str-1)).listeMateriaux().get(i).getQuantite(),aliments);
					}
				}
				for(int k = 0; k<ressourcesNonComestibles.size(); k++){
					if( (ressourcesNonComestibles.get(k)).toString()==(((listeFabrication.get(str-1)).listeMateriaux()).get(i)).toString()){
						this.jeterObjet(k,(listeFabrication.get(str-1)).listeMateriaux().get(i).getQuantite(),ressourcesNonComestibles);
					}
				}
				
			}
			System.out.println("Vous avez fabriqu� un " + listeFabrication.get(str-1).toString());
		}
  	}
  
  	/*public void manger(){ //LAU
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
 	}*/
  	public void combattre(){
	    Arme armeUtilisee;
	    if(equipement.size()==1){
	      System.out.println("Vous n'avez pas d'arme, vous attaquez donc avec vos poings.");
	      armeUtilisee = (Arme) equipement.get(0);
	    }
	    else{
	      	System.out.println("Quelle arme voulez vous utiliser?");
	      	this.afficherListe(equipement);
	      	int str = Integer.parseInt(sc.nextLine());
	      	while( str < 0 || str > equipement.size()){
	    		System.out.println("Mauvaise séléction. Recommencez.");
	    		str = Integer.parseInt(sc.nextLine());
	    	}
	      	armeUtilisee = (Arme) equipement.get(str-1); //le choix commence à 1
	    }
	    if((Math.random())<(armeUtilisee.getPrecision())){
	    	(carte[x][y].getOccupant()).perdSante(armeUtilisee.getDegat());
	      	armeUtilisee.descriptionReussite();
	      	if((carte[x][y].getOccupant()).getSante()<=0){
	        	(carte[x][y].getOccupant()).descriptionMort();
	        	this.ramasser(carte[x][y].getOccupant());
	        	(carte[x][y]).changerAnimal(null);
		}
	}
    	else
      		armeUtilisee.descriptionEchec();
    	if (carte[x][y].getOccupant() != null){ //ajout de possibilité mort donc plus sur la case
    		(carte[x][y].getOccupant()).reagirAttaque(this);
    	}
	}

	public void fuir(){ //LAU
  		(carte[x][y].getOccupant()).reagirFuite(this);
  		carte[x][y].changerAnimal(null);
  	}
  
  	public void pecher(){
  	
  	}
  	public void dormir() {
  		energie = energie + 60;
  		if(carte[x][y].getConstructions().size()==0) {
  			if(Math.random()<0.3) {
  				System.out.println("Vous avez �t� attaqu� par des animaux sauvages durant votre sommeil, vous perdez 15 PV");
  			}
  		date++;
  		}
  		System.out.println("Vous vous r�veillez le lendemain matin");
  	}
}
