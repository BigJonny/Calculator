package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static Interpreter interpreter = new Interpreter();
	public static ArrayList<String> eingaben = new ArrayList<String>();//Speichert alle Eingaben
	public static ArrayList<String> ausgaben = new ArrayList<String>();//Speichert alle Ausgaben
	public static int counter = 1;//Zählt jede neue Eingabeaufvorderung
	public static Rechner rechner = new Rechner();
	
	public static void main(String args[]) {
		System.out.println("Calculator:\nEnter '/help' for more information");
		while(true){
			System.out.println("(" + counter + ") ------------------------------------------");
			String eingabe = scanner.nextLine();
			String ausgabe = "";
			interpreter.interprete(eingabe);
			eingaben.add(eingabe);
			if(interpreter.isKey == false){
				ausgabe = rechner.getAusgabe(eingabe);
				System.out.println("Ausgabe: " + ausgabe);
				ausgaben.add(ausgabe);
			}
			counter++;
		}
	}
	
	
	public ArrayList<String> getEingaben(){
		return eingaben;
	}
	
	public ArrayList<String> getAusgaben(){
		return ausgaben;
	}
	
}
