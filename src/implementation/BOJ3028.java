package implementation;

import java.util.*;
import java.io.*;

public class BOJ3028 {

	static int[] cup = new int[3];

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		cup[0] = 1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'A') {
				change(0, 1);
			} else if (str.charAt(i) == 'B') {
				change(1, 2);
			} else {
				change(0, 2);
			}
		}
		
		for(int i = 0; i < 3; i++) {
			if(cup[i] == 1) {
				System.out.println(i + 1);
			}
		}
	}

	static void change(int start, int end) {
		int temp = cup[start];
		cup[start] = cup[end];
		cup[end] = temp;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
