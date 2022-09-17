package zSelfstudy;

public class Ch13_2 {
	class ThreadEx2{
		public void main (String args[]) throws Exception {
			ThreadEx2_1 t1 = new ThreadEx2_1();
			t1.start();
		}
	}
	
	class ThreadEx2_1 extends Thread {
		public void run() {
			throwException();
		}
		
		public void throwException() {
			try {
				throw new Exception();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
