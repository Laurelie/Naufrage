public class Ours extends AnimauxChassable{
     public Ours(){
          super("Ours", (int)(Math.random()*20+90), (int)(Math.random()*8+45), (int)(Math.random()*25+70));
          //nom poids rapportAlimentaire sante
     }
     public void reagirAttaque( Personnage p){
          if(Math.random()<0.2)
               txt.textAffichage("La griffe de l'ours vous manque de peu\n");
          else{
               int blessure = (int)(Math.random()*35+20);
               txt.textAffichage("Vous prenez un coup de patte dans l'abdomen qui vous retire "+blessure+" PV\n");
               p.modifierSante(-blessure);
          }
     }
     public void reagirFuite(Personnage p) {
  	     if(Math.random()<0.5){
               txt.textAffichage("L'ours vous voit : il vous court après\n");
               this.reagirAttaque(p);
          }
          else
               txt.textAffichage("L'ours mange du miel, il ne vous voit pas\n");
     }
}
