package sorting;

import java.util.*;
import java.io.*;

public class BOJ11557 {

	static class School implements Comparable<School>{
		String str;
		int num;

		public School(String str, int num) {
			this.str = str;
			this.num = num;
		}
		
		public int compareTo(School o) {
			return o.num - this.num;
		}
	}

	static void input() {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t--> 0) {
			ArrayList<School> school = new ArrayList<>();
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				String str = sc.next();
				int num = sc.nextInt();
				
				school.add(new School(str, num));
			}
			
			Collections.sort(school);
			System.out.println(school.get(0).str);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
