package sorting;

import java.util.*;
import java.io.*;

public class BOJ5635 {

	static class Student implements Comparable<Student> {
		String name;
		int day;
		int month;
		int year;

		public Student(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}

		public int compareTo(Student o) {
			if (this.year > o.year) {
				return 1;
			} else if (this.year == o.year) {
				if (this.month > o.month) {
					return 1;
				} else if (this.month == o.month) {
					if (this.day > o.day) {
						return 1;
					} else if (this.day == o.day) {
						return 0;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}
	}

	static int n;
	static ArrayList<Student> list = new ArrayList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			list.add(new Student(name, day, month, year));
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(n - 1).name);
		System.out.println(list.get(0).name);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
