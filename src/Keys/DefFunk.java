package Keys;

import java.util.Scanner;

import Main.PrivateFunktions;
import Opperatoren.OpperatorHandler;

public class DefFunk extends KeyWord{

	private OpperatorHandler opHandler = new OpperatorHandler();
	private PrivateFunktions pFunks = new PrivateFunktions();
	
	public DefFunk(String name, String task) {
		super(name, task);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void process(){
		System.out.println("Definieren einer Funktion:");
		Scanner scanner = new Scanner(System.in);
		String funktion = scanner.nextLine();
		if(pFunks.defFunk(funktion) == true){
			System.out.println("Funktion wurde erfolgreich aufgenommen und gespeichert");
		}
		else {
			System.out.println("Funktion wurde nicht gespeichert");
		}
	}


}
