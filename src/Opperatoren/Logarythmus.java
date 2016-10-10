package Opperatoren;

public class Logarythmus extends Opperator{

	public Logarythmus(String name, String task,int params) {
		super(name, task,params);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getResult(Double n){
		Double a = Math.log(n);
		String result = String.valueOf(a);
		return result;
	}

}
