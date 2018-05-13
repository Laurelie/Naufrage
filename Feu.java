import java.util.ArrayList;
import java.util.Scanner;

public class Feu extends Construction {
	Scanner sc = new Scanner(System.in);
	public ArrayList<Stockable> listeMateriaux() {
		ArrayList<Stockable> a = new ArrayList<Stockable>();
		a.add(new Bois(5));
		a.add(new Silex(2));
		return(a);
	}
	
	public Stockable clone() {
		return new Feu();
	}

	public void interagir(Personnage p) {
		txt.textAffichage("Que voulez vous faire cuire?\n");
		p.afficherListe(p.getAliments());
		int str = Integer.parseInt(sc.nextLine());
		while( str < 0 || str > p.getAliments().size()){
    		txt.textAffichage("Mauvaise selection. Recommencez.\n");
    		str = Integer.parseInt(sc.nextLine());
    	}
		((Mangeable)(p.getAliments().get(str-1))).estCuisine();
		txt.textAffichage("Vous avez cuit un "+p.getAliments().get(str-1).toString());
	}
	
}
