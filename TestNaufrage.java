import java.util.Scanner;
import java.lang.Thread;

public class TestNaufrage extends Txt{
	public static void main(String[] args) {
		Txt txt = new Txt();
     	Scanner sc = new Scanner(System.in);
     	String texte = "\nVous vous reveillez sur une plage deserte. Vous reprenez votre esprit petit à petit et vous vous souvenez que votre bateau a fait naufrage. \nVous ne voyez personne autour de vous... Vous etes seul.\n\nVous souvenez vous de votre nom ? Comment vous appelez-vous ?\n";
		txt.textAffichage(texte);

		String str = sc.nextLine();
		System.out.println("");
		Personnage p = new Personnage(str);
		/*p.ramasser(new Bois(10));
		p.ramasser(new Pierre(5));
		p.ramasser(new Ours());
		p.ramasser(new Lapin());
		p.ramasser(new Fil(1));*/
		Action.agir(p);
	}
}
