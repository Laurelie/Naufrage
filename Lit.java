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
		System.out.println("Voulez vous dormir?\n1) Oui\n2) Non");
		int n = Integer.parseInt(sc.nextLine());
		if(n!= 1 && n!=2) {
			System.out.println("Commande introuvable");
		}
		if(n==1) {
			System.out.println("Vous passez une nuit confortable dans votre lit");
			p.modifierEnergie(100);
			p.modifierDate(1);;
		}
	}
}
