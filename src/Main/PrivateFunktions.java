package Main;

import java.util.ArrayList;

/**
 * Dient zum Verwalten aller selbst definierten Funktionen
 * 
 * @author Jonas
 *
 */
public class PrivateFunktions {

	private String name = "";// Name der Funktion
	private int params = 0;// Anzahl der Parameter dieser Funktion
	private ArrayList funktion = new ArrayList();// Die Funktion in einem Array gespeicht
	private ArrayList<String> varNames = new ArrayList<String>();

	/**
	 * Speichert eine Funktion wenn diese Semantisch korrekt ist
	 * 
	 * @param eingabe
	 *            Die eingabe die in der DefFunk-Klasse vorgenommen wird
	 * @return True falls die Funktion erfolgreich gespeichert wurde, asnosnten
	 *         False
	 */
	public boolean defFunk(String eingabe) {
		validateFunk(eingabe);
		return false;
	}

	/**
	 * Validiert eine Funktion und setzt die Anzahl der für sie vorgesehenen
	 * Parameter
	 * 
	 * @param eingabe
	 * @return True falls die Validierung erfolgreich war ansonten False
	 */
	private boolean validateFunk(String eingabe) {
		String currentE = eingabe;
		try {
			if(currentE.contains(":=")){
				String linkeS = "";
				String rechteS = "";
				this.name = getFunktionName(eingabe);
				currentE = eingabe.substring(name.length());
				System.out.println(currentE + ", " + getParams(currentE));
				System.out.println(currentE.substring(params+3).trim());
				getRechnung(currentE.substring(params+3).trim());
				System.out.println(getRechnung(currentE.substring(params+3).trim()));
			}
		} catch (Exception e) {
			System.out.println("Etwas ist bei der Validierung dieser Funktion schief gelaufen");
		}
		return false;
	}

	/**
	 * Gibt den Namen einer definierten Funktion an
	 * 
	 * @param eingabe
	 *            Angegeben String
	 * @return Name der Funktion
	 */
	private String getFunktionName(String eingabe) {
		char c = '.';
		String name = "";
		if (eingabe.contains("(")) {
			for (int i = 0; i < eingabe.length(); i++) {
				c = eingabe.charAt(i);
				name = name + c;
				if (c != '(') {
					return name;
				}
			}
		}
		return name;
	}

	private int getParams(String rest) {
		int counter = 1;
		if (rest.contains(")") && rest.charAt(0) == '(') {
			for (int i = 0; i < rest.length(); i++) {
				if(rest.charAt(i) == ')'){
					return counter;
				}
				else if (rest.charAt(i) == ',') {
					counter++;
				}
				else {
					varNames.add(""+rest.charAt(i));
				}
			}
			return counter;
		} else {
			return -1;
		}
	}
	
	
	private String getRechnung(String rest){
		rest = rest.substring(2);
		for(int i = 0; i <varNames.size(); i++){//Schaut nach ob auch genau so viel Variabalen in der Gleichung sind wie vorgegeben
			if(rest.contains(varNames.get(i)) == false){
				return "";
			}
			for(int j = 0; j < rest.length(); j++){
				if("" + rest.charAt(j) == varNames.get(i)){
					rest = "0" + rest.substring(1);
				}
			}
		}
		
		//Rechner r = new Rechner();
		return rest;
	}
}
