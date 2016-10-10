package Keys;

import Main.Variablen;

public class ShowAllVars extends KeyWord{
	
	private Variablen vars;

	public ShowAllVars(String name, String task) {
		super(name, task);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void process(){
		super.ShowVars();
	}
}
