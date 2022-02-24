package java_selfstudy;

class Calculator {
	int x;
	int y;
	
	public int sum() {
		return x+y;		
	}
	public int subtract() {
		return x-y;		
	}
	public int multifly() {
		return x*y;		
	}
	public int devide() {
		return x/y;		
	}
}






public class Mogakko12 {
	public static void main (String[] args) {
		Calculator calculator = new Calculator();
		calculator.x=30;
		calculator.y=50;
		
		System.out.println(calculator.x+"+"+calculator.y+"="+calculator.sum());
		System.out.println(calculator.x+"-"+calculator.y+"="+calculator.subtract());
		System.out.println(calculator.x+"*"+calculator.y+"="+calculator.multifly());
		System.out.println(calculator.x+"/"+calculator.y+"="+calculator.devide());
		
	}

}
