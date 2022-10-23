package sorting;

import java.util.*;
import java.io.*;

public class BOJ2535 {
	static class Student {
		int country;
		int id;
		int score;
		
		public Student(int country, int id, int score) {
			this.country = country;
			this.id = id;
			this.score = score;
		}
	}
	
	static int n;
	static ArrayList<Student> list = new ArrayList<>();
	static int[] country = new int[101];
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int id = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			list.add(new Student(c, id, score));
		}
		
		list.sort(new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return o2.score - o1.score;
			}
		});
		
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			if(country[list.get(i).country] < 2 && result < 3) {
				country[list.get(i).country]++;
				result++;
				System.out.println(list.get(i).country + " " + list.get(i).id);
			}
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
