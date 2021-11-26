package implementation;

import java.util.*;
import java.io.*;

public class BOJ10799 {

	static String str = "";

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		str = str.replace("()", "L");

		int ans = 0;
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'L') {
				ans += cnt;
			} else if (str.charAt(i) == '(') {
				cnt++;
			} else if(str.charAt(i) == ')') {
				ans++;
				cnt--;
			}
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
