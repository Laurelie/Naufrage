import java.util.Scanner;
import java.lang.Thread;

public class TestNaufrage extends Txt{
	public static void main(String[] args) {
		Ile chargementIle = new Ile();
		Txt txt = new Txt();
     	Scanner sc = new Scanner(System.in);
     	String texte = "\nVous vous reveillez sur une plage deserte. Vous reprenez votre esprit petit à petit et vous vous souvenez que votre bateau a fait naufrage. \nVous ne voyez personne autour de vous... Vous etes seul.\n\nVous souvenez vous de votre nom ? Comment vous appelez-vous ?\n";
		txt.textAffichage(texte);

		String str = sc.nextLine();
		System.out.println("");
		Personnage p = new Personnage(str);

		//aide
		p.ramasser(new Bois(40));
		p.ramasser(new Pierre(5));
		p.ramasser(new Fil(1));
		p.ramasser(new Silex(3));

		while(!Action.quitterJeu){
			try{
				Action.agir(p);
			}
			catch(NumberFormatException e){
				txt.textAffichage("Entrez un nombre !\n");
			}
		}
	}
}
