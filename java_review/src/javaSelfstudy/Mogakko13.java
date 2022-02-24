package javaSelfstudy;

class Student {
	String name;
	int x, y, z;
	Student(String name, int x, int y, int z) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public void getAverage() {
		System.out.println(name+"의 평균 점수: "+ (float)(x+y+z) / 3 );
	}
}

public class Mogakko13 {
	public static void main (String[] args) {
		Student s1 = new Student("코뮤",100,80,75);
		Student s2 = new Student("김변수",96,58,90);
		
		s1.getAverage();
		s2.getAverage();
		
	}

}
