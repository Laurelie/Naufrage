public class Ours extends AnimauxChassable{
  public Ours(){
    super("Ours", 100, 80, (int)(Math.random()*10)+10);
  }
  public void reagirAttaque( Personnage p){
    if(Math.random()<0.2){
      txt.textAffichage("La griffe de l'ours vous manque de peu\n");
    }
    else{
      txt.textAffichage("Vous prenez un coup de patte dans l'abdomen qui vous retire 20 PV\n");
      p.modifierSante(-20);
    }
  }
  public void reagirFuite(Personnage p) { //LAU
  	if(Math.random()<0.5){
      txt.textAffichage("L'ours vous voit : il vous court après\n");
      this.reagirAttaque(p);
    }
    else{
      txt.textAffichage("L'ours mange du miel, il ne vous voit pas\n");
    }
  }
}
