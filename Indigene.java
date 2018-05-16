
public class Indigene extends AnimauxChassable{
	private static boolean indigeneVaincu=false;
	public Indigene() {
		super("Indigene",700,-30,60);
	}

	public void reagirAttaque(Personnage p) {
		if(Math.random()<0.8) {
			txt.textAffichage("Le colosse a l'air tres enerve.\n Il vous frappe avec sa massue vous perdez 20 PV\n");
			p.modifierSante(-20);
			return;
		}
		txt.textAffichage("L'indigene essaye de repliquer avec sa massue qui passse par chance a quelques centimetres de votre tete\n");
	}

	public void reagirFuite(Personnage p) {
		txt.textAffichage("Les indigenes vous regardent faire en riant.\n Leur champion vous crache dessus.\n");
	}

	public void descriptionMort() {
		txt.textAffichage("Vous voyez la masse de muscle en face de vous s'effondrer.\n Le reste de la tribu s'enfuit alors en courant.\n Vous decouvrez alors sur la plage bordant le village la carcasse d'un enorme bateau.\n Il est peut etre possible de le remettre a flot...\n");
		indigeneVaincu=true;
	}
	public static boolean getIndigeneVaincu() {
		return indigeneVaincu;
	}
}
