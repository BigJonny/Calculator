package Main;

import java.util.ArrayList;

/**
 * Diese Klasse dient dem Speichern und Auslesen von selbst definierten Variablen
 * @author Jonas
 *
 */
public class Variablen {

	private static ArrayList vars = new ArrayList();
	private String name = "";
	private String wert = "";
	
	
	/**
	 * Definiert eine neue Variable mit dem gegebenen String
	 * @param o Variable als String : VariablenName, VariablenWert
	 */
	public void defVar(String o){
		if(bereitsVorhanden(onlyName(o)) != -1){
			System.out.println("Variable " + onlyName(o) + " wird überschrieben mit dem Wert " + onlyValue(o));
			overwriteVar(onlyName(o));
		}
		vars.add(o);
	}
	
	public ArrayList getVarList(){
		return this.vars;
	}
	
	/**
	 * Gibt alle vorhandenen Variablen in der Konsole aus
	 */
	public void showVars(){
		System.out.println("Alle vorhandenen Variablen: ");
		for(int i = 0; i< vars.size(); i++){
			printElement(i);
		}
		System.out.println("-- Ende --");
	}
	
	/**
	 * Gibt eine einzige Variable an der Stelle index aus
	 * @param index Index
	 */
	private void printElement(int index){
		name = "";
		wert = "";
		boolean elem1 = true;
		String in = vars.get(index).toString();
		for(int i = 0; i < in.length(); i++){
			if(in.charAt(i) == ','){
				elem1 = false;
			}
			else if(elem1 == true){
				name = name + in.charAt(i);
			}
			else if(elem1 == false && in.charAt(i) != ','){
				wert = wert + in.charAt(i);
			}
		}
		System.out.println("Variable("+ index + "): " + name + " = " + wert);
	}
	
	/**
	 * Sucht alle Vorkommen von Variablen und ersetzt diese durch ihren angegeben Wert
	 * @param eingabe
	 * @return
	 */
	public String containsVars(String eingabe){
		for(int i = 0; i < vars.size(); i++){
			String currentVarName = getVarName(i);
			String currentVarValue = getVarValue(i);
			//System.out.println(currentVarName + ", value: " + currentVarValue);
			if(eingabe.contains(currentVarName)){
				eingabe = eingabe.replaceAll(currentVarName, currentVarValue);
			}
		}
		return eingabe;
	}
	
	/**
	 * Gibt den Namen einer Variable zurück inkluse des Prefixes "V."
	 * @param index Index der Variable
	 * @return "V." + Variablenname
	 */
	private String getVarName(int index){
		String ausgabe = vars.get(index).toString();
		int i = ausgabe.indexOf(",");
		return "V." + ausgabe.substring(0,i);
	}
	/**
	 * Gibt den Wert einer Variable an der Stelle index an
	 * @param index Index der Variable
	 * @return Wert der Variable
	 */
	private String getVarValue(int index){
		String ausgabe = vars.get(index).toString();
		int i = ausgabe.indexOf(",");
		return ausgabe.substring(i+1);
	}
	
	/**
	 * Prüft ob eine Variable mit diesem Namen bereits Vorhanden ist
	 * @param varName Name der Variable die auf ihren Namen geprüft werden soll
	 * @return True falls eine mit dem gleichen Namen gefunden wurde, ansonten False
	 */
	private int bereitsVorhanden(String varName){
		varName = "V."+ varName;
		for(int i = 0; i < vars.size();i++){
			if(varName.equals(getVarName(i))){
				return i;
			}
		}
		return -1;
	}
	
	private String onlyName(String in){
		int i = 0;
		if(in.contains(",")){
			i = in.indexOf(",");
		}
		return in.substring(0,i);
	}
	
	private String onlyValue(String in){
		int i = 0;
		if(in.contains(",")){
			i = in.indexOf(",");
		}
		return in.substring(i+1);
	}
	
	/**
	 * Schaut nach ob ein Variable bereits definiert wurde und löscht diese gegebenenfalls
	 * @param varName Name der zu prüfenden Variable ohne Prefix oder Suffix
	 */
	private void overwriteVar(String varName){
		for(int i = 0; i < vars.size(); i++){
			if(onlyName(vars.get(i).toString()).equals(varName)){
				vars.remove(i);
			}
		}
	}
	
}
