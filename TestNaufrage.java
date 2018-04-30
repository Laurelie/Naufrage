import java.util.Scanner;

public class TestNaufrage {
	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
		System.out.println("\nVous vous reveillez sur une plage deserte. Vous reprenez votre esprit petit à petit et vous vous souvenez que votre bateau a fait naufrage. \nVous ne voyez personne autour de vous... Vous etes seul.");
		System.out.println("\nVous souvenez vous de votre nom ? Comment vous appelez-vous ?");
		String str = sc.nextLine();
		System.out.println("");
		Personnage p = new Personnage(str);
		p.ramasser(new Bois(10));
		p.ramasser(new Pierre(5));
		p.ramasser(new Ours());
		p.ramasser(new Lapin());
		p.ramasser(new Fil(1));
		Action.agir(p);
	}
}
