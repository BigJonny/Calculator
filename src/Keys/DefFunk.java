package Keys;

import java.util.Scanner;

import Opperatoren.OpperatorHandler;

public class DefFunk extends KeyWord{

	private OpperatorHandler opHandler = new OpperatorHandler();
	
	public DefFunk(String name, String task) {
		super(name, task);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void process(){
		System.out.println("Definieren einer Funktion:");
		Scanner scanner = new Scanner(System.in);
		String funktion = scanner.nextLine();
		System.out.println(funktion);
	}

}
