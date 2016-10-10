package Keys;

import java.util.ArrayList;
import java.util.Scanner;

import Main.Variablen;

/**
 * Dient zum Erstellen eines Keywords um Befehle speichern zu können
 * @author Jonas
 *
 */
public class KeyWord {

	private String name;
	private String task;
	private Variablen vars;
	
	public KeyWord(String name, String task){
		this.name = name;
		this.task = task;
		vars = new Variablen();
	}
	
	
	public String getName(){
		return this.name;
	}
	public String getTask(){
		return this.task;
	}
	
	public void process(){
		
	}
	public void setVars(Variablen newVars){
		this.vars = newVars;
		vars.showVars();
	}
	public void ShowVars(){
		vars.showVars();
	}
	public void defVar(){
		System.out.println("Variable festlegen:");
		Scanner scanner = new Scanner(System.in);
		String in = scanner.nextLine();
		try{
			if(in.contains(":=")){
				boolean elem1 = true;
				String name = "";
				String wert = "";
				for(int i = 0; i < in.length(); i++){
					if(in.charAt(i) == ':' && in.charAt(i+1) == '='){
						elem1 = false;
					}
					else if(elem1 == true){
						name = name + in.charAt(i);
					}
					else if(elem1 == false && in.charAt(i) != '=' && in.charAt(i) != ':'){
						wert = wert + in.charAt(i);
					}
				}
				vars.defVar(name.trim() + "," + wert.trim());
				System.out.println("Variable wurde gespeichert mit den Namen: " + name.trim() + " und dem Wert " + wert.trim());
			}
		}catch(Exception e){
			System.out.println("Error: Definition ungültig");
		}
	}


}
