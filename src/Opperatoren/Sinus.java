package Opperatoren;

public class Sinus extends Opperator{

	public Sinus(String name, String task,int params) {
		super(name, task,params);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String getResult(Double n){
		double a = Math.sin(Math.toRadians(n));
		return String.valueOf(a);
	}

}
