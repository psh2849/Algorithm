package implementation;

import java.util.*;
import java.io.*;

public class BOJ9093 {

	static int t;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();
			String[] split = str.split(" ");

			for (int i = 0; i < split.length; i++) {
				String s = "";
				for (int j = split[i].length() - 1; j >= 0; j--) {
					s += split[i].charAt(j);
				}
				sb.append(s + " ");
			}
			
			System.out.println(sb);
			sb.delete(0, sb.length());
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
