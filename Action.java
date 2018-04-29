import java.util.Scanner;
public class Action{
     static Scanner sc = new Scanner(System.in);
     public static void agir(Personnage p){
     	if(p.getSante() <=0)     //LAU : arreter des qu'il y a game over
     		return;
     	if(p.getEnergie()<=0) {
     		System.out.println("Vous vous effondrez � cause de la fatigue");
     		p.dormir();
     	}
     	System.out.println("\n\tQue voulez-vous faire?\n\n");
          boolean nord = false;
          boolean sud = false;
          boolean est = false;
          boolean ouest = false;
          boolean commandeExecutee = false;
          Lieu[][] carte = p.getCarte();
          int x =p.getX();
          int y =p.getY();
          Lieu position = carte[x][y];
          if(position.getOccupant()!=null){
               System.out.println("1) Fuir \n2) Chasser \n3) Ignorer");
               int str = Integer.parseInt(sc.nextLine());
               if(str==1){
            	   System.out.println("Vous essayez de fuir");
                    p.fuir();
                    int alea = (int)(Math.random()*5);
                    if(alea==0)
                 		p.seDeplacer("Nord");
                 	else if(alea==1)
                 		p.seDeplacer("Sud");
                 	else if(alea==2)
                 		p.seDeplacer("Ouest");
                 	else if(alea==3)
                 		p.seDeplacer("Est");
                    p.modifierEnergie(-10);
                    //faire bouger avec les cas hors du terrains
               }
               if(str==2){
                    p.combattre();
                    p.modifierEnergie(-10);
               }
               if(str==3){
            	   System.out.println("Vous ignorez l'animal");
                    p.fuir();
               }
               if(str!=1 && str!=2 && str!=3){
                    System.out.println("Commande introuvable.");
               }
               Action.agir(p);
          }
          else{
               if(!((carte[x-1][y].getNom()).equals("Mer"))){
                  System.out.println("1) Aller au Nord.");
                  nord = true;
               }
               else
                  System.out.println("1) Vous êtes bloqué par la mer au Nord");

               if(!((carte[x+1][y].getNom()).equals("Mer"))){
                  System.out.println("2) Aller au Sud.");
                  sud = true;
               }
               else
                  System.out.println("2) Vous êtes bloqué par la mer au Sud");

               if(!(carte[x][y-1].getNom()).equals("Mer")){
                  System.out.println("3) Aller a l'ouest.");
                  ouest = true;
               }
               else
                  System.out.println("3) Vous êtes bloqué par la mer a l'ouest.");

               if(!(carte[x][y+1].getNom()).equals("Mer")){
                  System.out.println("4) Aller a l'est.");
                  est = true;
               }
               else
                  System.out.println("4) Vous êtes bloqué par la mer a l'est.");

               System.out.println("5) Manger. \n6) Fabriquer \n7) Afficher la carte \n8) Afficher son statut \n9) Consulter l'inventaire\n10) Actions spécifiques au lieu");
               int str = Integer.parseInt(sc.nextLine());
               if(str==1 && nord){
                  p.seDeplacer("Nord");
                  commandeExecutee=true;
                  p.modifierEnergie(-10);
               }
               if(str==2 && sud){
                  p.seDeplacer("Sud");
                  commandeExecutee=true;
                  p.modifierEnergie(-10);
               }
               if(str==3 && est){
                  p.seDeplacer("Est");
                  commandeExecutee=true;
                  p.modifierEnergie(-10);
               }
               if(str==4 && ouest){
                  p.seDeplacer("Ouest");
                  commandeExecutee=true;
                  p.modifierEnergie(-10);
               }
               /*if(str==5){
                  p.manger();
                  commandeExecutee=true;
               }*/
               if(str==6){
                  p.fabriquer();
                  commandeExecutee=true;
               }
               
               if(str==7){
                    p.afficherCarte();
                    commandeExecutee=true;
               }
               if(str==8){
                    p.afficherStatut();
                    commandeExecutee=true;
               }
               if(str==9){
                    p.consulterInventaire();
                    commandeExecutee=true;
               }
               /*if(str==10){
                    position.choixAction();
                    commandeExecutee=true;
                    p.modifierEnergie(-10);
               }
               */
               if(!commandeExecutee){
                    System.out.println("Commande introuvable.");
               }
               Action.agir(p);
          }
     }
}
