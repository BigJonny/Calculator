package Opperatoren;

import java.util.Random;

public class RandInt extends Opperator{

	public RandInt(String name, String task, int params) {
		super(name, task, params);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String getResult(Object[] array) {
		int a = Integer.parseInt(array[0].toString());
		int b = Integer.parseInt(array[1].toString());
		Random rand = new Random();
		int c = 0;
		if(b > a){
			c = b - rand.nextInt(a);
		}
		else if(a > b){
			c = a - rand.nextInt(b);
		}
		else {
			c = a;
		}
		String result = String.valueOf(c);
		return result;
	}

}
