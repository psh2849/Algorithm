package etc;

import java.io.*;
import java.util.*;

public class BOJ1076 {
	
	static class Product {
		String color;
		int value;
		int mul;
		
		public Product(String color, int value, int mul) {
			this.color = color;
			this.value = value;
			this.mul = mul;
		}
	}
	static ArrayList<Product> list = new ArrayList<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		saveData();
		
		int cnt = 1;
		long answer = 0;
		for(int i = 1; i <= 3; i++) {
			String str = br.readLine();
			for(Product p : list) {
				if(p.color.equals(str)) {
					if(i != 3) {
						answer = answer * cnt + p.value;
						cnt *= 10;
					} else {
						answer *= p.mul;
					}
					
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static void saveData() {
		list.add(new Product("black", 0, 1));
		list.add(new Product("brown", 1, 10));
		list.add(new Product("red", 2, 100));
		list.add(new Product("orange", 3, 1000));
		list.add(new Product("yellow", 4, 10000));
		list.add(new Product("green", 5, 100000));
		list.add(new Product("blue", 6, 1000000));
		list.add(new Product("violet", 7, 10000000));
		list.add(new Product("grey", 8, 100000000));
		list.add(new Product("white", 9, 1000000000));
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
