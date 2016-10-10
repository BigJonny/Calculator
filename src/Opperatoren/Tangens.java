package Opperatoren;

public class Tangens extends Opperator{

	public Tangens(String name, String task, int params) {
		super(name, task, params);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String getResult(Double n){
		Double a = Math.tan(n);
		String result = String.valueOf(a);
		return result;
	}

}
