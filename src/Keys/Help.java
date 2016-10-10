package Keys;

import java.awt.event.KeyListener;
import java.util.ArrayList;

import Main.Konstanten;
import Opperatoren.Opperator;
import Opperatoren.OpperatorHandler;

/**
 * Das Help KeyWord ruft eine Liste aller vorhandenen KeyWords und Opperatoren auf
 * @author Jonas
 *
 */
public class Help extends KeyWord{

	private ArrayList<KeyWord> keyList;
	private OpperatorHandler opHandler = new OpperatorHandler();
	private Konstanten kons = new Konstanten();
	
	public Help(String name, String task, ArrayList<KeyWord> keyList) {
		super(name, task);
		this.keyList = keyList;
	}
	
	public void process(){
		System.out.println("Liste aller Befehle:");
		for(int i = 0; i < keyList.size() ; i++){
			System.out.println(keyList.get(i).getName() + " -- " + keyList.get(i).getTask());
		}
		System.out.println("-- Ende --");
		
		System.out.println("Liste aller bereits definierten Funktionen:");
		ArrayList<Opperator> opList = opHandler.getOpList();
		for(int i = 0; i < opList.size() ; i++){
			System.out.println(opList.get(i).getName() + " -- " + opList.get(i).getTask());
		}
		System.out.println("-- Ende --");
		kons.printKons();
	}

}
