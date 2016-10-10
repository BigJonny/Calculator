package Keys;

import java.util.ArrayList;

import Main.Variablen;

/**
 * Initialisiert alle vorhandenen KeyWords
 * @author Jonas
 *
 */
public class KeyWordHandler {
	private ArrayList<KeyWord> keys = new ArrayList<KeyWord>();

	public KeyWordHandler(){
		Help help = new Help("/help", "Listet alle KeyWords, Funktionen und Konstanten auf", this.keys);
		keys.add(help);
		Exit exit = new Exit("/exit", "Beendet das Programm umgehend");
		keys.add(exit);
		PrintAllIn printAllIn = new PrintAllIn("/printAllIn","Listet alle je gemachten Eingaben inklusive nicht gültiger"
				+ " Eingaben oder Befehle auf");
		keys.add(printAllIn);
		PrintAllOut printAllOut = new PrintAllOut("/printAllOut", "Listet alle je erzeugten Ausgaben auf");
		keys.add(printAllOut);
		DefVar defVar = new DefVar("/defV", "Definiert eine Variable mit einem beliebigen werd oder einem beliegen vorhandenem Objekt oder Variable.\n"
				+ "	 zu beachten ist das eine Variable nur mit Buchstaben definiert werden darf\n"
				+ "	 und sich auch nich mit den Namen von schon vorhanden Befehlen überscheiden darf\n"
				+ "	 Um eine Variable anzusprechen muss diese mit folgendem Prefix verwiesen werden: 'V.' \n"
				+ "	 Eine Variable wird folgendermaßen definiert: 'name := Wert'");
		keys.add(defVar);
		ShowAllVars showAllv = new  ShowAllVars("/showVars", "Listet alle bereits definierten Variablen auf");
		keys.add(showAllv);
		DefFunk defF = new DefFunk("/defF", "Definiert eine beliebige semantisch korrekte Funktion");
		keys.add(defF);
	}
	
	
	/**
	 * Prüft ob die vorgenomme Eingabe ein KeyWord ist
	 * @param eingabe 
	 * @return Index falls es eines ist ansonsten -1
	 */
	public int isKey(String eingabe){
		for(int i = 0; i < keys.size(); i++){
			if(eingabe.equals(keys.get(i).getName())){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Führt den Befehl eines Keywords an der Stelle i aus 
	 * @param i Index
	 */
	public void exicuteKey(int i){
		keys.get(i).process();
	}
	
	
	
}
