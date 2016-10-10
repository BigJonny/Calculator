package Keys;

public class Exit extends KeyWord{

	public Exit(String name, String task) {
		super(name, task);
		// TODO Auto-generated constructor stub
	}
	
	public void process(){
		System.out.println("Programm beendet");
		System.exit(0);
	}

}
