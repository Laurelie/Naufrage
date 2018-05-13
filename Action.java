import java.util.Scanner;

public class Action extends Txt{
     static Txt txt = new Txt();
     static Scanner sc = new Scanner(System.in);
     public static void agir(Personnage p){
    	if(Bateau.getNbBateau()==2) {
    		return;
    	}
     	if(p.getSante() <=0)     //LAU : arreter des qu'il y a game over
     		return;
     	if(p.getEnergie()<=0){
     		txt.textAffichage("\n\tVous vous effondrez a cause de la fatigue !\n\n");
     		p.dormir();
     	}
      //Rappeler quand on a sommeil
      if(p.getEnergie()<30) txt.textAffichage("\n\tVous avez du mal à voir, vos yeux se ferment tout seul... Vous sentez venir la fatigue\n\n");
     	//rappeler quand on manque de sante
      if(p.getSante()<30) txt.textAffichage("\n\tGRARH !!! Votre ventre gronde. Pensez à vous nourrir !\n\n");

      txt.textAffichage("\n\tQue voulez-vous faire "+p.getNom()+" ?\n");
          p.mAjprofil();
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
               txt.textAffichage("1) Fuir \n2) Chasser \n3) Ignorer\n");
               int str = Integer.parseInt(sc.nextLine());
               if(str==1){
            	   txt.textAffichage("Vous essayez de fuir\n");
                    p.fuir();
                    int alea = (int)(Math.random()*4);
                    //cas au centre
                    if (!((carte[x-1][y].getNom()).equals("Mer")) && !((carte[x+1][y].getNom()).equals("Mer")) && !((carte[x][y-1].getNom()).equals("Mer")) && !((carte[x][y+1].getNom()).equals("Mer"))){ //fuir a gauche
	                    if(alea==0)
	                 		p.seDeplacer("Nord");
	                 	else if(alea==1)
	                 		p.seDeplacer("Sud");
	                 	else if(alea==2)
	                 		p.seDeplacer("Ouest");
	                 	else if(alea==3)
	                 		p.seDeplacer("Est");
                    }
                    //cas haut 
                    if ((carte[x-1][y].getNom()).equals("Mer")){ //fuir en bas
                    	if ((carte[x][y-1].getNom()).equals("Mer")){ //fuir a droite
                    		if (alea==0 || alea ==1)
                    			p.seDeplacer("Sud");
                    		else
                    			p.seDeplacer("Ouest");
                    	}
                    	else if ((carte[x][y+1].getNom()).equals("Mer")){ //fuir a gauche
                    		if (alea==0 || alea ==1)
                    			p.seDeplacer("Sud");
                    		else
                    			p.seDeplacer("Est");
                    	}
                    	else{
                    		alea = (int)(Math.random()*3); //3choix
                    		if(alea==0)
	                 			p.seDeplacer("Sud");
	                 		else if(alea==1)
	                 			p.seDeplacer("Ouest");
	                 		else
	                 			p.seDeplacer("Est");
                    	}
                    }
       				//cas bas
                    if ((carte[x+1][y].getNom()).equals("Mer")){ //fuir en haut
                    	if ((carte[x][y-1].getNom()).equals("Mer")){ //fuir a droite
                    		if (alea==10 || alea ==1)
                    			p.seDeplacer("Nord");
                    		else
                    			p.seDeplacer("Ouest");
                    	}
                    	else if ((carte[x][y+1].getNom()).equals("Mer")){ //fuir a gauche
                    		if (alea==10 || alea ==1)
                    			p.seDeplacer("Nord");
                    		else
                    			p.seDeplacer("Est");
                    	}
                    	else{
                    		alea = (int)(Math.random()*3); //3choix
                    		if(alea==0)
	                 			p.seDeplacer("Nord");
	                 		else if(alea==1)
	                 			p.seDeplacer("Ouest");
	                 		else
	                 			p.seDeplacer("Est");
                    	}
                    }

                    //cas gauche
                    if ((carte[x][y+1].getNom()).equals("Mer")){ //fuir a gauche
                    		alea = (int)(Math.random()*3); //3choix
                    		if(alea==0)
	                 			p.seDeplacer("Nord");
	                 		else if(alea==1)
	                 			p.seDeplacer("Ouest");
	                 		else
	                 			p.seDeplacer("Sud");
                    }

                    //cas droit
                    if ((carte[x][y-1].getNom()).equals("Mer")){ //fuir a droite
                    		alea = (int)(Math.random()*3); //3choix
                    		if(alea==0)
	                 			p.seDeplacer("Nord");
	                 		else if(alea==1)
	                 			p.seDeplacer("Sud");
	                 		else
	                 			p.seDeplacer("Est");
                    }
                    
                    p.modifierEnergie(-5);
               }
               if(str==2){
                    p.combattre();
                    p.modifierEnergie(-10);
               }
               if(str==3){
            	   txt.textAffichage("Vous ignorez l'animal\n");
                    p.fuir();
               }
               if(str!=1 && str!=2 && str!=3){
                    txt.textAffichage("Commande introuvable. Recommencez\n");
               }
               Action.agir(p);
          }
          else{
               if(!((carte[x-1][y].getNom()).equals("Mer"))){
                  txt.textAffichage("1) Aller au Nord.\n");
                  nord = true;
               }
               else
                  txt.textAffichage("1) Vous etes bloque par la mer au Nord\n");

               if(!((carte[x+1][y].getNom()).equals("Mer"))){
                  txt.textAffichage("2) Aller au Sud.\n");
                  sud = true;
               }
               else
                  txt.textAffichage("2) Vous etes bloque par la mer au Sud\n");

               if(!(carte[x][y-1].getNom()).equals("Mer")){
                  txt.textAffichage("3) Aller a l'ouest.\n");
                  ouest = true;
               }
               else
                  txt.textAffichage("3) Vous etes bloque par la mer a l'ouest.\n");

               if(!(carte[x][y+1].getNom()).equals("Mer")){
                  txt.textAffichage("4) Aller a l'est.\n");
                  est = true;
               }
               else
                  txt.textAffichage("4) Vous etes bloque par la mer a l'est.\n");

               txt.textAffichage("5) Manger. \n6) Fabriquer \n7) Afficher la carte \n8) Afficher son statut \n9) Consulter l'inventaire\n10) Choix propre au lieu\n\n\n\t\t\tPressez 0 pour quitter le jeu\n\n");
               int str = Integer.parseInt(sc.nextLine());
               if (str==0)
                return;
               if(str==1 && nord){
                  p.seDeplacer("Nord");
                  commandeExecutee=true;
                  p.modifierEnergie(-5);
               }
               if(str==2 && sud){
                  p.seDeplacer("Sud");
                  commandeExecutee=true;
                  p.modifierEnergie(-5);
               }
               if(str==3 && ouest){
                  p.seDeplacer("Ouest");
                  commandeExecutee=true;
                  p.modifierEnergie(-5);
               }
               if(str==4 && est){
                  p.seDeplacer("Est");
                  commandeExecutee=true;
                  p.modifierEnergie(-5);
               }
               if(str==5){
                  p.manger();
                  commandeExecutee=true;
               }
               if(str==6){
                  p.fabriquer();
                  commandeExecutee=true;
                  //p.modifierEnergie(-10); pas modifier si on fait retour
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
               //AJOUTER LE CHOIX DORMIR ? Quand on se trouve dans un camp ?
               if(str==10){
                    position.choixAction(p);
                    commandeExecutee=true;
                    //p.modifierEnergie(-10); pas modifier si on fait retour
               }
               
               if(!commandeExecutee){
                    txt.textAffichage("Commande introuvable. Recommencez\n");
               }
               Action.agir(p);
          }
     }
}
