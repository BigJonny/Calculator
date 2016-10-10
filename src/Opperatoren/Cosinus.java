package Opperatoren;

public class Cosinus extends Opperator{

	public Cosinus(String name, String task, int params) {
		super(name, task,params);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String getResult(Double n){
		Double a = Math.cos(n);
		String result = String.valueOf(a);
		return result;
	}
}
