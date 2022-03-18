package etc;

import java.io.*;
import java.util.*;

public class BOJ1755 {

	static class Point implements Comparable<Point> {
		int number;
		String str;

		public Point(int number) {
			this.number = number;
			int num1 = number / 10;
			int num2 = number % 10;

			if (number >= 10) {
				str = numToStr[num1] + " " + numToStr[num2];
			} else {
				str = numToStr[num2];
			}
		}

		public int compareTo(Point o) {
			return str.compareTo(o.str);
		}
	}

	static String numToStr[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	static int n, m;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Point po[] = new Point[m - n + 1];
		
		int index = n;
		for (int i = 0; i < m - n + 1; i++) {
			po[i] = new Point(index);
			index++;
		}
		
		Arrays.sort(po);
		for(int i = 0; i < po.length; i++) {
			if(i != 0 && i % 10 == 0) System.out.println();
			System.out.print(po[i].number + " ");
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
