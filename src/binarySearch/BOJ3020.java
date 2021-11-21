package binarySearch;

import java.util.*;
import java.io.*;

public class BOJ3020 {
	static int n, h;
	static int[] top, bottom;
	static int min, cnt;
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		min = n;
		top = new int[h + 1];
		bottom = new int[h + 1];
		for(int i = 0; i < n / 2; i++) {
			bottom[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}

		search();
		
		System.out.println(min + " " + cnt);
	}
	
	static void search() {
		int[] topSum = new int[h + 1];
		int[] bottomSum = new int[h + 1];
		
		for(int i = 1; i <= h; i++) {
			topSum[i] = topSum[i - 1] + top[i];
			bottomSum[i] = bottomSum[i - 1] + bottom[i];
		}
		
		for(int i = 1; i <= h; i++) {
			int crush = 0;

			crush += topSum[h] - topSum[h - i];
			crush += bottomSum[h] - bottomSum[i - 1];
			System.out.println(bottomSum[h] + " " + bottomSum[i] + " " + bottomSum[i - 1]);
			if(crush < min) {
				min = crush;
				cnt = 1;
			} 
			else if(min == crush) {
				cnt++;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
