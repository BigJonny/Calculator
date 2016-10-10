package Keys;

import java.util.Scanner;

import Main.Variablen;

public class DefVar extends KeyWord{

	private Variablen vars = new Variablen();
	public DefVar(String name, String task) {
		super(name, task);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void process(){
		super.defVar();
	}

}
