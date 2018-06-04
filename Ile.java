import java.util.Scanner;

public class Ile extends Txt{
	static Txt txt = new Txt();
	static Scanner sc = new Scanner(System.in);
	private static Lieu carte[][];
	private static int x;
	private static int y;
	public Ile(){
		carte = new Lieu[6][6];

		//initialisation de la map
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(i==0 || i==5 || j==0 || j==5){
					carte[i][j]= new Mer();
					carte[i][j].decouvrir(); //la mer doit etre notifie tout le temps
				}

				else if (i==1 || j==1) {
					if(i==3)
						carte[i][j] = new Village();
					else
						carte[i][j] = new Plage();
				}

				else if (i==4 || j==4)
					carte[i][j] = new Montagne();

				else 
					carte[i][j] = new Foret();
			}
		}
	}
	public static Lieu[][] getCarte(){
		return carte;
	}
	public static void afficherCarte(){
		txt.textAffichage("Voici votre carte :\n");
		String ligne ="\n";
		for(int i=0;i<carte.length;i++){
			ligne = "\t";
			for(int j = 0;j<carte[i].length;j++){
				if(x==i && y==j) {
					ligne+= "  XX";
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
			txt.textAffichage(ligne+"\n");
		}
		txt.textAffichage("\nInconnu = In : vous n'avez pas encore découvert cet endroit\nMontagne = Mo\nForet = Fo\nMer = Me\nPlage = Pl\nCamp = Ca\nVotre position = XX\n\n");
		txt.textAffichage("\t\t\tPressez 0 pour retour.\n\n");
		int str = Integer.parseInt(sc.nextLine());
		while(str!=0){
			txt.textAffichage("Commande invalide. Recommencez\n");
			str = Integer.parseInt(sc.nextLine());
		}
		return;
	}
}