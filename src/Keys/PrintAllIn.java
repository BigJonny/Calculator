package Keys;

import java.util.ArrayList;

import Main.Main;


public class PrintAllIn extends KeyWord{

	
	private ArrayList eList = new ArrayList();
	Main m = new Main();
	
	public PrintAllIn(String name, String task){
		super(name,task);
	}
	
	@Override
	public void process(){
		eList = m.getEingaben();
		System.out.println("Liste aller Eingaben: ");
		for(int i = 0; i < eList.size(); i++){
			System.out.println("(" + (i + 1) +") -- '"+ eList.get(i).toString() + "'");
		}
		System.out.println("-- Ende --");
	}
	
}
