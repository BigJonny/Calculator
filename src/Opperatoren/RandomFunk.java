package Opperatoren;

import java.util.Random;

public class RandomFunk extends Opperator{
	private Random rand = new Random();
	
	
	
	public RandomFunk(String name, String task, int params) {
		super(name, task,params);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getResult(Double n){
		int a = n.intValue();
		String result = String.valueOf(rand.nextInt(a));
		return result;
	}

}
