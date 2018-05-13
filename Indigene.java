
public class Indigene extends AnimauxChassable implements Chassable{
	private static boolean indigeneVaincu=false;
	public Indigene() {
		super("Indigene",700,-10,100);
	}

	public void reagirAttaque(Personnage p) {
		if(Math.random()<0.8) {
			txt.textAffichage("Le colosse a l'air très énervé.\n Il vous frappe avec sa massue vous perdez 40 PV");
			p.modifierSante(-40);
			return;
		}
		txt.textAffichage("L'indigene essaye de répliquer avec sa massue qui passse par chance à quelques centimetres de votre tete");
	}

	public void reagirFuite(Personnage p) {
		txt.textAffichage("Les indigenes vous regardent faire en riant.\n Leur champion vous crache dessus.");
	}

	public void descriptionMort() {
		txt.textAffichage("Vous voyez la masse de muscle en face de vous s'effondrer.\n Le reste de la tribu s'enfuit alors en courant.\n Vous découvrez alors sur la plage bordant le village la carcasse d'un enorme bateau.\n Il est peut etre possible de le remettre à flot...");
		indigeneVaincu=true;
	}
	public static boolean getIndigeneVaincu() {
		return indigeneVaincu;
	}
}
