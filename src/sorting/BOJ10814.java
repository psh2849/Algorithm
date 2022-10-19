package sorting;

import java.util.*;
import java.io.*;

public class BOJ10814 {
	static class Person implements Comparable<Person>{
		int id;
		int age;
		String name;
		
		public Person(int id, int age, String name) {
			this.id = id;
			this.age = age;
			this.name = name;
		}
		
		public int compareTo(Person p) {
			if(this.age == p.age) {
				return this.id - p.id;
			} else {
				return this.age - p.age;
			}
		}
	}
	
	static int n;
	static ArrayList<Person> list = new ArrayList<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			list.add(new Person(i, age, name));
		}
		
		Collections.sort(list);
		for(int i = 0; i < n; i++) {
			System.out.println(list.get(i).age + " " + list.get(i).name);
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
