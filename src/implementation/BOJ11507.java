package implementation;

import java.util.*;
import java.io.*;

public class BOJ11507 {

	static String str = "";
	static int[] p, k, h, t;
	static String s = "";
	static int cp = 13, ck = 13, ch = 13, ct = 13;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		str = str.replaceAll("10", "A");
		str = str.replaceAll("11", "B");
		str = str.replaceAll("12", "C");
		str = str.replaceAll("13", "D");
		str = str.replaceAll("0", "");

		p = new int[21];
		k = new int[21];
		h = new int[21];
		t = new int[21];

		boolean isBoolean = true;
		for (int i = 0; i < str.length(); i += 2) {
			char ch = str.charAt(i);
			char ch1 = str.charAt(i + 1);

			if (ch == 'P') {
				isBoolean = pro(p, ch1);
				if(!isBoolean) {
					return;
				}
			} else if (ch == 'K') {
				isBoolean = pro(k, ch1);
				if(!isBoolean) {
					return;
				}
			} else if (ch == 'H') {
				isBoolean = pro(h, ch1);
				if(!isBoolean) {
					return;
				}
			} else if (ch == 'T') {
				isBoolean = pro(t, ch1);
				if(!isBoolean) {
					return;
				}
			}
		}
		
		for (int i = 0; i < p.length; i++) {
			if (i >= 10 && i <= 16)
				continue;
			if (p[i] != 0)
				cp--;
		}

		for (int i = 0; i < k.length; i++) {
			if (i >= 10 && i <= 16)
				continue;
			if (k[i] != 0)
				ck--;
		}

		for (int i = 0; i < h.length; i++) {
			if (i >= 10 && i <= 16)
				continue;
			if (h[i] != 0)
				ch--;
		}

		for (int i = 0; i < t.length; i++) {
			if (i >= 10 && i <= 16)
				continue;
			if (t[i] != 0)
				ct--;
		}

		System.out.println(cp + " " + ck + " " + ch + " " + ct);
	}

	static boolean pro(int[] arr, char num) {
		if (arr[num - '0'] != 0) {
			System.out.println("GRESKA");
			return false;
		} else {
			arr[num - '0']++;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
