package implementation;

import java.util.*;
import java.io.*;

public class BOJ15953 {

	static int t;
	static int[] first = new int[22];
	static int[] second = new int[32];

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		saveData();
		t = Integer.parseInt(br.readLine());
		
		int answerf = 0;
		int answers = 0;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			if(f > 21) {
				answerf = 0;
			} else {
				answerf = first[f];
			}
			if(s > 31) {
				answers = 0;
			} else {
				answers = second[s];
			}
			
			System.out.println(answerf + answers);
		}
	}

	static void saveData() {
		for (int i = 1; i <= 21; i++) {
			if (i == 1) {
				first[i] = 5000000;
			} else if (i == 2 || i == 3) {
				first[i] = 3000000;
			} else if (i >= 4 && i <= 6) {
				first[i] = 2000000;
			} else if (i >= 7 && i <= 10) {
				first[i] = 500000;
			} else if (i >= 11 && i <= 15) {
				first[i] = 300000;
			} else {
				first[i] = 100000;
			}
		}

		for (int i = 1; i <= 31; i++) {
			if (i == 1) {
				second[i] = 5120000;
			} else if (i == 2 || i == 3) {
				second[i] = 2560000;
			} else if (i >= 4 && i <= 7) {
				second[i] = 1280000;
			} else if (i >= 8 && i <= 15) {
				second[i] = 640000;
			} else {
				second[i] = 320000;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
