package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1120 {
	
	static String str1 = "";
	static String str2 = "";
	static int min = Integer.MAX_VALUE;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		str1 = st.nextToken();
		str2 = st.nextToken();
		
		for(int i =0; i < str2.length() - str1.length() + 1; i++) {
			int cnt = 0;
			for(int j = 0; j < str1.length(); j++) {
				if(str1.charAt(j) != str2.charAt(i + j)) {
					cnt++;
				}
			}
			
			if(min > cnt) {
				min = cnt;
			}
		}
		
		System.out.println(min);
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
