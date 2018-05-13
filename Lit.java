import java.util.ArrayList;
import java.util.Scanner;


public class Lit extends Construction{
	Scanner sc = new Scanner(System.in);
	public Stockable clone() {
		return new Lit();
	}
	public ArrayList<Stockable> listeMateriaux(){
		ArrayList<Stockable> buffer = new ArrayList<Stockable>();
		buffer.add(new Bois(15));
		return buffer;
	}
	public void interagir(Personnage p) {
		txt.textAffichage("Voulez vous dormir?\n1) Oui\n2) Non\n");
		int n = Integer.parseInt(sc.nextLine());
		if(n!= 1 && n!=2) {
			txt.textAffichage("Commande introuvable");
		}
		if(n==1) {
			txt.textAffichage("Vous passez une nuit confortable dans votre lit\n");
			p.modifierEnergie(100);
			p.modifierDate(1);;
		}
	}
	public String toString() {
		return("Lit");
	}
}
