package zSelfstudy;

import java.awt.List;
import java.util.ArrayList;

public class Ch11_2 {
	class ArrayListEx2 {
		public void main(String[] args) {
			final int LIMIT = 10;
			String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
			int length = source.length();
			
			ArrayList<String> list = new ArrayList(length/LIMIT + 10);
			
			for(int i=0; i<length; i+=LIMIT) {
				if (i+LIMIT < length) {
					list.add(source.substring(i, i+LIMIT));
				}
				else {
					list.add(source.substring(i));
				}
			}
			
			for(int i=0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			
		}
	}

}
