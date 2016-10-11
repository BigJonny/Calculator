package Main;

import java.util.ArrayList;

import Keys.KeyWordHandler;
import Opperatoren.Opperator;
import Opperatoren.OpperatorHandler;

/**
 * Ein Interpreter, der alle Eingabe auf ihre Gültigkeit prüft und sie
 * gegebenfalls an die Calculator-Klasse übergibt
 * 
 * @author Jonas
 *
 */
public class Interpreter {

	private KeyWordHandler keyHandler = new KeyWordHandler();
	Main m = new Main();
	private ArrayList<String> rechnung = new ArrayList<String>();
	private OpperatorHandler opHandler = new OpperatorHandler();
	public boolean isKey = false;
	
	/**
	 * Schaut ob es sich bei der vorgenommen Eingabe um einen Befehl oder eine Rechnung handelt.
	 * Handelt es sich um einen Befehl wird dieser Ausgeführt
	 * @param eingabe Eingabe Aus der Main-Klasse
	 */
	public void interprete(String eingabe) {
		if (eingabe.isEmpty() == false) {
			if (eingabe.charAt(0) == '/') {
				int index = keyHandler.isKey(eingabe);
				if(index != -1){
					exicuteKey(index);
					m.counter --;
					isKey = true;
				}
				else {
					System.out.println("Kein Befehl mit diesem Nanem vorhanden");
				}
			}
			else {
				isKey = false;
			}
		}
	}
	
	/**
	 * Führt einen bestimmten Befehl an der Stelle i aus
	 * @param index
	 */
	private void exicuteKey(int index){
		keyHandler.exicuteKey(index);
	}
	
	/**
	 * Sucht an erster Stelle des gegeben Strings nach einer Zahl solange bis ein anderes ASCII zeichen auftaucht
	 * So ergibt eine Eingabe: "12378a" zb die Zahl 12378 oder die Eingabe : "12 + 2" die Zahl 12
	 * @param part Eingegener String
	 * @return Eine Zahl als String oder "" falls es an erster Stelle keine Zahl gibt 
	 */
	public String getNumber(String part){
		boolean number = true;
		String ausgabe = "";
		for(int i = 0;i < part.length(); i++){
			if((part.charAt(i) > 47 && part.charAt(i) < 58 || part.charAt(i) == '.') && number == true){
				ausgabe = ausgabe + part.charAt(i);
			}
			else {
				number = false;
				return ausgabe;
				
			}
		}
		return ausgabe;
	}
	
	/**
	 * Schaut nach ob es sich bei dem ersten Characters des Strings part um ein Rechenzeichen handelt
	 * @param part
	 * @return Gibt das ensprechende Rechenzeichen zurück ansonten ""
	 */
	public String getRechenzeichen(String part){
		//Single char Opperators:
		if(part.charAt(0) == '+' || part.charAt(0) == '-' || part.charAt(0) == '*' || part.charAt(0) == ':'){
			return "" + part.charAt(0);
		}
		return "";
	}
	
	public String getOpperator(String part){
		String p = "";
		for(int i = 0; i < opHandler.getSize(); i++){
			Opperator op = opHandler.getOpByID(i);
			if(part.length() > op.getName().length()){
				p = part.substring(0, op.getName().length() + 1);
				if(p.equals(op.getName()+ "(")){
					return p;
				}	
			}
		}
		return "";
	}
	
	
}
