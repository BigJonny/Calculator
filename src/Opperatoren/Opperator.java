package Opperatoren;

public class Opperator {
	private String name;
	private String task;
	private int params;

	public Opperator(String name, String task, int params){
		this.name = name;
		this.task = task;
		this.params = params;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getTask(){
		return this.task;
	}
	
	public String getResult(Double n){
		return "";
	}
	
	public int getParams(){
		return this.params;
	}
	

	public String getResult(Object[] array) {
		// TODO Auto-generated method stub
		return "";
	}
}
