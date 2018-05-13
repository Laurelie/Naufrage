
public class Indigene extends AnimauxChassable implements Chassable{
	private static boolean indigeneVaincu=false;
	public Indigene() {
		super("Indigene",700,-10,100);
	}

	public void reagirAttaque(Personnage p) {
		if(Math.random()<0.8) {
			txt.textAffichage("Le colosse a l'air tr�s �nerv�.\n Il vous frappe avec sa massue vous perdez 40 PV");
			p.modifierSante(-40);
			return;
		}
		txt.textAffichage("L'indigene essaye de r�pliquer avec sa massue qui passse par chance � quelques centimetres de votre tete");
	}

	public void reagirFuite(Personnage p) {
		txt.textAffichage("Les indigenes vous regardent faire en riant.\n Leur champion vous crache dessus.");
	}

	public void descriptionMort() {
		txt.textAffichage("Vous voyez la masse de muscle en face de vous s'effondrer.\n Le reste de la tribu s'enfuit alors en courant.\n Vous d�couvrez alors sur la plage bordant le village la carcasse d'un enorme bateau.\n Il est peut etre possible de le remettre � flot...");
		indigeneVaincu=true;
	}
	public static boolean getIndigeneVaincu() {
		return indigeneVaincu;
	}
}
