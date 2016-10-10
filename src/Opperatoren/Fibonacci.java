package Opperatoren;

public class Fibonacci extends Opperator{

	public Fibonacci(String name, String task, int params) {
		super(name, task, params);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getResult(Double n){
		String result = "";
		if(n <= -1){
			result = "0";
			System.out.println("Error:Die Fibonacci-Funktion kann nicht mit einem Wert Unter 0 aufgerufen wern, \n"
					+ "Das Ergebnis wurde auf 0 gesetzt");
			return result;
		}
		result = String.valueOf(fib(n.intValue()));
		return result;
	}
	
	private int fib(int i){
		if(i == 0){
			return 1;
		}
		if(i == 1){
			return 2;
		}
		return fib(i-1) + fib(i -2);
	}

}
