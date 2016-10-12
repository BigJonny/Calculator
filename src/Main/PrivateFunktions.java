package Main;

import java.util.ArrayList;

import Opperatoren.OpperatorHandler;

/**
 * Dient zum Verwalten aller selbst definierten Funktionen
 * 
 * @author Jonas
 *
 */
public class PrivateFunktions {

	private OpperatorHandler opHandler = new OpperatorHandler();

	/**
	 * Speichert eine Funktion wenn diese Semantisch korrekt ist
	 * 
	 * @param eingabe
	 *            Die eingabe die in der DefFunk-Klasse vorgenommen wird
	 * @return True falls die Funktion erfolgreich gespeichert wurde, asnosnten
	 *         False
	 */
	public boolean defFunk(String eingabe) {
		if(getParts(eingabe) != null){
			return true;
		}
		return false;
	}

	/**
	 * Befüllt ein Array das die drei Informationen Name,Variablen und Rechnung aufnimmt
	 * @param eingabe Eingabe
	 * @return Array mit gewünschten Infos ,asnonten null
	 */
	private String[] getParts(String eingabe){
		String name = "";
		String variablen = "";
		String rechnung = "";
		int counter = 0;
		String[] cParts = new String[3];
		for(int i = 0; i< eingabe.length(); i++){
			if(eingabe.charAt(i) == '(' && counter == 0)
			{
				counter = 1;
				cParts[0] = name;
				System.out.println("Name:" + cParts[0]);
			}
			if(eingabe.charAt(i) == ')' && counter == 1){
				counter = 2;
				cParts[1] = variablen;
				System.out.println("Variablen :" + cParts[1]);
			}
			if(eingabe.charAt(i) == ':' && eingabe.charAt(i +1) == '='){
				counter = 2;
			}
			if(counter == 0){
				name = name + eingabe.charAt(i);
			}
			else if(counter == 1 && eingabe.charAt(i) != '('){
				variablen = variablen + eingabe.charAt(i);
			}
			else if(counter == 2 && eingabe.charAt(i) != ':' && eingabe.charAt(i) != '=' && eingabe.charAt(i) != ')'){
				rechnung = rechnung + eingabe.charAt(i);
			}
		}
		cParts[2] = rechnung;
		System.out.println("Rechnung :" + cParts[2]);
		if(rechnung.isEmpty() == true || variablen.isEmpty() == true || name.isEmpty() == true){
			return null;
		}
		if(checkRechnung(cParts)  == false){
			return null;
		}
		return cParts;
	}
	
	
	private boolean checkRechnung(String[] cParts){
		Rechner r = new Rechner();
		String rechnung = cParts[2];
		ArrayList<String> vars = new ArrayList<String>();
		String currentVarname = "";
		for(int i = 0; i < cParts[1].length();i++){
			if(cParts[1].charAt(i) == ','){
				vars.add(currentVarname);
				currentVarname = "";
			}
			else if(i == cParts[1].length() -1){
				currentVarname = currentVarname + cParts[1].charAt(i);
				vars.add(currentVarname);
			}
			else {
				currentVarname = currentVarname + cParts[1].charAt(i);
			}
		}
		
		for(int i = 0; i < vars.size(); i++){
			if(rechnung.contains(vars.get(i))){
				rechnung = rechnung.replaceAll(vars.get(i), "1");
			}
			else {
				System.out.println("Error: Die Funktion"+ cParts[0] +" enthält nicht alle für sie vorgesehenen Variablen");
				return false;
			}
		}
		try{
			Double d = Double.valueOf(r.getAusgabe(rechnung));
			System.out.println(r.getAusgabe(rechnung));
		}catch(Exception e){
			System.out.println("Error: Funktion ist mathematisch nicht korrekt");
			return false;
		}
		return true;
	}
	
}
