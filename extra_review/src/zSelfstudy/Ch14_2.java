package zSelfstudy;

public class Ch14_2 {

	@FunctionalInterface
	interface Myfunction {
		void myMethod();
	}
	
	class LambdaEx2 {
		public void main (String[] args) {
			Myfunction f = () -> {};
			Object obj = (Myfunction)(()->{});
			String str =((Object)(Myfunction)(()->{})).toString();
			
			System.out.println(f);
			System.out.println(obj);
			System.out.println(str);
		}
	}
}
