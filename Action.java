import java.util.Scanner
public class Action{
   Scanner sc = new Scanner(System.in);
   public static void agir(Personnage p){
        boolean nord,sud,est,ouest,commandeExecutee = false;
        Lieu[][] carte = p.getCarte();
        int x =p.getX();
        int y =p.getY();
        Lieu position = carte[x][y];
        if(position.getOccupant()!=null){
            System.out.println("1) Fuir \n2) Chasser \n3)Ignorer");
            int str = sc.nextLine();
            if(str==1){
               p.fuir();
             }
            if(str==2){
               p.combattre();
              }
            if(str==3){
               p.ignorer()
               }
            if(str!=1 && str!=2 && str!=3){
               System.out.println("Commande introuvable.");
              }
            Action.agir();
            }
         else{
            if(not(carte[x][y-1].getNom()).equals("Mer")){
               System.out.println("1) Aller au Nord.");
               nord = true;
               }
             else{
               System.out.println("1) Vous êtes bloqué par la mer au Nord"
               }
             if(not(carte[x][y+1].getNom()).equals("Mer")){
               System.out.println("2) Aller au Sud.");
               sud = true;
               }
             else{
               System.out.println("2) Vous êtes bloqué par la mer au Sud"
               }
             if(not(carte[x-1][y].getNom()).equals("Mer")){
               System.out.println("3) Aller a l'ouest.");
               ouest = true;
               }
             else{
               System.out.println("3) Vous êtes bloqué par la mer a l'ouest."
               }
             if(not(carte[x+1][y].getNom()).equals("Mer")){
               System.out.println("4) Aller a l'est.");
               est = true;
               }
             else{
               System.out.println("4) Vous êtes bloqué par la mer a l'est."
               }
              System.out.println("5) Manger. \n6) Fabriquer \n7) Afficher la carte \n8) Afficher son statut \n9) Consulter l'inventaire\n10) Actions spécifiques au lieu")
              int str = sc.nextLine();
              if(str==1 && nord){
               p.seDeplacer("Nord");
               commandeExecutee=true,
               }
              if(str==2 && sud){
               p.seDeplacer("Sud");
               commandeExecutee=true,
               }
              if(str==3 && est){
               p.seDeplacer("Est");
               commandeExecutee=true,
               }
              if(str==4 && ouest){
               p.seDeplacer("Ouest");
               commandeExecutee=true,
               }
              if(str==5){
               p.manger();
               commandeExecutee=true,
               }
              if(str==6){
               p.fabriquer();
               commandeExecutee=true,
               }
              if(str==7){
               p.afficherCarte();
               commandeExecutee=true,
               }
              if(str==8){
               p.afficherStatut();
               commandeExecutee=true,
               }
              if(str==9){
               p.???;
               commandeExecutee=true,
               }
              if(str==10){
               position.choixAction();
               commandeExecutee=true,
               }
               if(not commandeExecutee){
                  System.out.println("Commande introuvable.")
                  }
               Action.agir(p);
         }
}
              
               
 
          
         
      