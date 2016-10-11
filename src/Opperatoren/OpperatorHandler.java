 package Opperatoren;

import java.util.ArrayList;

public class OpperatorHandler {
	
	private ArrayList<Opperator> opList = new ArrayList<Opperator>();
	private int size = 1;

	public OpperatorHandler(){
		Sinus sinus = new Sinus("sin","Gibt den Sinus einer rationalen Zahl n aus, 'sin(n)'",1);
		opList.add(sinus);
		Cosinus cosinus = new Cosinus("cos", "Gibt den Cosinus einer rationalen Zahl n aus, 'cos(n)'",1);
		opList.add(cosinus);
		Tangens tangens = new Tangens("tan", "Gibt den Tangens einer rationalen Zahl n aus, 'tan(n)'",1);
		opList.add(tangens);
		Fibonacci fib = new Fibonacci("fib", "Berechnet die Zahl in der Faboniccafolge an der nten Stelle, 'fib(n)",1);
		opList.add(fib);
		RandomFunk randFunk = new RandomFunk("randInt", "Gibt einen zufälligen Integer von 0 bis n zurück, 'randInt(n)' ",1);
		opList.add(randFunk);
		RandInt randInt = new RandInt("randInt2", "Berechnet eine Zufallszahl zwischen a und b egal welche von beiden größer ist , 'randInt2(a,b)", 2);
		opList.add(randInt);
		Logarythmus nLog = new Logarythmus("logn", "Berechnet den natürlichen Logarythmus einer ratioealen Zahl n, 'logn(n)",1);
		opList.add(nLog);
		this.size = opList.size();
		//TODO: Instanz der Wurzel-Klasse erzeugen und in dei opList aufnehmen
	}
	
	
	public ArrayList getOpList(){
		return opList;
	}
	
	public int getSize(){
		return this.size;
	}
	
	
	public Opperator getOpByID(int index){
		if(index > -1 && index < opList.size()){
			if(index < this.size){
				return opList.get(index);
			}
		}
		return null;
	}
	
	public int getIDByOp(String op){
		int id = -1;
		for(int i = 0; i < opList.size(); i++){
			if(opList.get(i).getName().equals(op)){
				return i;
			}
		}
		return id;
	}
	
	/**
	 * Schaut nach ob es in der Liste aller Opperatoren einen mit den Namem name gibt
	 * @param name Name des Opperators inklsive "("
	 * @return True falls dieses Element gefunden wurde, ansonten Flase
	 */
	public boolean contains(String name){
		for(int i = 0; i< opList.size(); i++){
			if(name.equals(opList.get(i))){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Prüft ob in einen gegeben RechnungsArray ein Opperator vorhanden ist
	 * @param rechnung Gegeben RechnungsArray
	 * @return True falls ein Opperator gefunden ansonsten False
	 */
	public boolean contains(ArrayList rechnung){
		for(int i = 0; i < rechnung.size(); i++){
			for(int j = 0; j< opList.size(); j++){
				if(rechnung.get(i).toString().equals(opList.get(j) + "(")){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
