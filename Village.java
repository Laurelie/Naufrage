
public class Village extends Lieu{
	private boolean aCarcasse = false;
	protected Village() {
		super("Village indigene");
	}

	public void choixAction(Personnage p) {
		if(aCarcasse) {
			txt.textAffichage("Les habitants se sont enfuis avec toutes leurs possessions. Il ne reste rien a faire ici");
		}
		else {
			aCarcasse = true;
			txt.textAffichage("Vous allez inspecter la carcasse, et vous etablissez la liste des materiaux necessaire a sa construction.");
			p.ajouterAListeFabrication( new Bateau());
		}
	}

	public void genererAnimal() {
		if(!Indigene.getIndigeneVaincu()) {
			this.changerAnimal(new Indigene());
		}
	}

	public void genererObjet() {
	}

	public void decrireLieu() {
		if(!Indigene.getIndigeneVaincu()) {
			txt.textAffichage("Vous arrivez dans un village peuple d'indigenes.\n Ils se mettent rapidement en cercle autour de vous.\n Vous voyez alors surgire d'une hutte, un titan de deux metre avec une enorme massue.\n" );
			return;
		}
		txt.textAffichage("Vous penetrez dans le village indigene. Il est completement vide.");
	}

}
