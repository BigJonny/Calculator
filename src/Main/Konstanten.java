package Main;

import java.util.ArrayList;

/**
 * Diese Klasse enthählt wichte mathematische konstanten und deren Kürzel mit dessen Hilfe
 * man mit diese Konstanten rechnen kann
 * @author Jonas
 *
 */
public class Konstanten {
	
	private String[] names;
	private String[] konstanten;
	
	public Konstanten(){
		names = new String[2];
		konstanten = new String[2];
		
		names[0] = "#.pi";
		konstanten[0] = String.valueOf(Math.PI);
		names[1] = "#.e";
		konstanten[1] = String.valueOf(Math.E);		
	}
	

	/**
	 * Prüft ob sich innerhalb des gegeben String input ein konstante befindet
	 * @param input
	 */
	public String checkInput(String input){
		for(int i = 0; i < 2;i++){
			if(input.contains(names[i])){
				int index = input.indexOf(names[i]);
				input = input.replaceAll(names[i], konstanten[i]);
			}
		}
		return input;
	}
	
	public void printKons(){
		System.out.println("Liste Aller mathematischen Konstanten:");
		for(int i = 0; i < 2; i++){
			System.out.println("Name: " +names[i].substring(2) + " -- Wert: " +konstanten[i]);
		}
		System.out.println("Wichtiger Hinweis: Um eine Konstante richtig zu verwenden schreibt man vor den Namen\n"
				+ "der Konstanten das Kürzel '#.'. Eine korrekte Eingabe wäre dem entsprechent : '#.pi'");
		System.out.println("-- Ende --");
	}

}
