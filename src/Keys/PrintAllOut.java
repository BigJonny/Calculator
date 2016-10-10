package Keys;

import java.util.ArrayList;

import Main.Main;

public class PrintAllOut extends KeyWord{
	Main m = new Main();
	private ArrayList ausgaben = new ArrayList();

	public PrintAllOut(String name, String task) {
		super(name, task);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void process(){
		this.ausgaben = m.getAusgaben();
		printArrayList(ausgaben);
	}

	private void printArrayList(ArrayList ausgaben){
		System.out.println("Alle Ausgaben:");
		for(int i = 0; i< ausgaben.size(); i++){
			System.out.println("("+i+") -- " + ausgaben.get(i).toString());
		}
		System.out.println("-- Ende --");
		
	}
}
