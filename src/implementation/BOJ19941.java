package implementation;

import java.util.*;
import java.io.*;

public class BOJ19941 {

	static int n, m;
	static char[] str;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		str = new char[n];
		
		String s = br.readLine();
		for(int i = 0; i < s.length(); i++) {
			str[i] = s.charAt(i);
		}
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (str[i] == 'P') {
				int left = i - m;
				int right = i + m;

				if (left < 0) {
					left = 0;
				}

				if (right > n - 1) {
					right = n - 1;
				}

				for (int j = left; j <= right; j++) {
					if(str[j] == 'H') {
						answer++;
						str[j] = '.';
						break;
					}
				}
			}
		}
		
		System.out.println(answer);

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
