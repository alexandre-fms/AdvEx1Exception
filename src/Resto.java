import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Exercice 3.1 : Gestion de fichiers / retour sur le Tp Resto
 *Le gérant du resto souhaite imprimer les menus pour les déposer sur les
 *tables des clients d’une part
 *et les transmettre en cuisine d’autre part afin de simplifier son organisation.
 *→ Voilà à quoi devrait ressembler le contenu du fichier une fois généré
 * @author ArenasA , sur la base de correction de Mohamed El Babili
 *
 */

public class Resto {
		public static final String [] STARTER = 	{"entrée", "salade","soupe","quiche","aucune"};
		public static final String [] DISHES = 		{"plats" , "poulet" , "boeuf" , "poisson" , "végétarien" , "vegan","aucun"};
		public static final String [] SIDE_DISH = 	{"accompagnements" , "riz" , "pates" , "frites" , "légumes","aucun"};
		public static final String [] DRINKS = 		{"boissons" , "eau plate" , "eau gazeuze" , "soda" , "vin","aucune"};
		public static final String [] DESSERTS = 	{"desserts" , "tarte maison" , "mousse au chocolat" , "tiramisu","aucun"};
		
	public static void main(String[] args) {	
		
		File file = new File("menu.txt");
		try {
			if (file.createNewFile()){
				 System.out.println("Fichier créé!");
				 }else{
				 System.out.println("Fichier existe déjà.");
				 }
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.println("bonjour, combien de menus souhaitez vous ?");
			Scanner scan = new Scanner(System.in);
			int nbMenu;
			while(scan.hasNextInt() == false)	scan.next();
			nbMenu = scan.nextInt();
			ArrayList<String>  order = new ArrayList<String>();
			for(int i = 0 ; i < nbMenu ; i ++) {
				
				bw.write("******************** Résumé de la commande numéro " + (i+1) + " **********************");
				
				System.out.println("Commande numéro " + (i+1));
				int result = getInfos(scan,STARTER[0]);
				if(STARTER.length-1 > result) {
					order.add(STARTER[result]);
					bw.write("\n" + STARTER[result]);
				}
			
				result = getInfos(scan,DISHES[0]);
				if(DISHES.length-1 > result) {
					order.add(DISHES[result]);
					bw.write("\n" + DISHES[result]);
				}
				
				result = getInfos(scan,SIDE_DISH[0]);
				if(SIDE_DISH.length-1 > result) {
					order.add(SIDE_DISH[result]);
					bw.write("\n" + SIDE_DISH[result]);
				}
				
				result = getInfos(scan,DRINKS[0]);
				if(DRINKS.length-1 > result) {
					order.add(DRINKS[result]);
					bw.write("\n" + DRINKS[result]);
				}
				
				result = getInfos(scan,DESSERTS[0]);
				if(DESSERTS.length-1 > result) {
					order.add(DESSERTS[result]);
					bw.write("\n" + DESSERTS[result]);
				}
				bw.write("\n\n");
				
				System.out.println("Résumé de la commande "+(i+1));
				System.out.println(order);		//ici on pourrait stocker la commande en base par exemple
				System.out.println();			//avant de passer à la suivante
				order.clear();
			}	
			scan.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static int getInfos(Scanner scan, String info) {
		System.out.println("choix " + info + " : ");
		if(info.equalsIgnoreCase(STARTER[0]))	displayTable(STARTER);
		else if(info.equalsIgnoreCase(DISHES[0]))	displayTable(DISHES);
		else if(info.equalsIgnoreCase(SIDE_DISH[0]))	displayTable(SIDE_DISH);
		else if(info.equalsIgnoreCase(DRINKS[0]))	displayTable(DRINKS);
		else if(info.equalsIgnoreCase(DESSERTS[0]))	displayTable(DESSERTS);		
		System.out.println("que souhaitez vous comme "+ info + " ? [saisir le chiffre correspondant]");
		return scan.nextInt();
	}	
	public static void displayTable(String [] table) {
		for(int i=1;i<table.length;i++) {			
			System.out.print("[" + i + " - " + table[i].toUpperCase() + "]");
		}
		System.out.println();
	}
}
