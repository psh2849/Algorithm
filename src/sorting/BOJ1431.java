package sorting;

import java.util.*;
import java.io.*;

public class BOJ1431 {

	static class Guitar implements Comparable<Guitar>{
		String name;
		int sum;

		public Guitar(String name, int sum) {
			this.name = name;
			this.sum = sum;
		}
		
		public int compareTo(Guitar o) {
			if(name.length() > o.name.length()) {
				return 1;
			} else if(name.length() < o.name.length()) {
				return -1;
			} else if(name.length() == o.name.length()) {
				if(sum > o.sum) {
					return Integer.compare(sum, o.sum);
				} else if(sum < o.sum) {
					return Integer.compare(sum, o.sum);
				} else {
					return name.compareTo(o.name);
				}
			} 
			
			return 0;
		}
	}

	static int n;
	static ArrayList<Guitar> list = new ArrayList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			int sum = getSum(str);

			list.add(new Guitar(str, sum));
		}
		Collections.sort(list);
		
		for(Guitar g : list) {
			System.out.println(g.name);
		}
	}

	static int getSum(String str) {
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '1' && str.charAt(i) <= '9') {
				sum += str.charAt(i) - '0';
			}
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
