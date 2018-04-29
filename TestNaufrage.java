
public class TestNaufrage {
	public static void main(String[] args) {
		Personnage p = new Personnage("Georges");
		p.ramasser(new Bois(10));
		p.ramasser(new Pierre(5));
		p.ramasser(new Ours());
		p.ramasser(new Fil(1));
		Action.agir(p);
	}
}
