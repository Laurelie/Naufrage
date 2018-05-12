import java.lang.Thread; //bibli pour utiliser sleep

//afichage letter par lettre

public class Txt{
  public void textAffichage(String texte){
  		String[] txt = texte.split("");
  		for(int i=0; i<txt.length;i++){
     		System.out.print(txt[i]);
     		  try {
               	Thread.sleep(5);
         	} catch (InterruptedException e) {
         		  System.out.println(e.getMessage());
             	// gestion de l'erreur
         	}
     	}
  }
}