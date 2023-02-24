
import java.util.Scanner;
import java.lang.Math;
/**
 * 
 * @author ArenasA
 *
 */
public class Game {
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Bonjour souhaitez vous jouer à mon jeu O/N?");	
		String str = scan.next();
		while(str.equalsIgnoreCase("oui") || str.equalsIgnoreCase("o")){
			int nbAleatoire = (int)(Math.random()*100) + 1;
			System.out.println(nbAleatoire);
			int counter = 1, val = 0;
			System.out.println("saisissez une valeur comprise entre 1 et 100");
			while(val != nbAleatoire){				
				val = scan.nextInt();
				if( val > nbAleatoire)		System.out.println("saisissez une valeur plus petite");
				else if( val < nbAleatoire)	System.out.println("saisissez une valeur plus grande");
				else System.out.printf("vous avez trouvé en %d coups \n", counter); 
				counter++;
			}
			System.out.println("Voulez vous rejouer ?");
			str = scan.next();
		};
		System.out.println("au revoir");	
		scan.close();
	}
}
