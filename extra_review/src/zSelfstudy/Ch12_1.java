package zSelfstudy;

import java.util.ArrayList;


public class Ch12_1 {

	class Fruit { public String toString() { return "Fruit"; }}
	class Apple extends Fruit { public String toString() { return "Apple"; }}
	class Grape extends Fruit { public String toString() { return "Grape"; }}
	class Toy { public String toString() { return "Toy"; }}
	
	class FruitBoxEx1 {
		public void main(String[] args) {
			Box<Fruit> fruitBox = new Box<Fruit>();
			Box<Apple> appleBox = new Box<Apple>();
			Box<Toy> toyBox = new Box<Toy>();
			
			fruitBox.add(new Fruit());
			fruitBox.add(new Apple());
			
			appleBox.add(new Apple());
			appleBox.add(new Apple());
			
			toyBox.add(new Toy());
			
			System.out.println(fruitBox);
			System.out.println(appleBox);
			System.out.println(toyBox);
		}
	}
}
	class Box<T>{
		ArrayList<T> list = new ArrayList<T>();
		void add(T item) { list.add(item);

	}
}
