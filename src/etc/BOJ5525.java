package etc;

import java.util.*;
import java.io.*;

public class BOJ5525 {

	static int n, s;
	static String str;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		s = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		char[] arr = str.toCharArray();
		int[] memo = new int[s];
		int ans = 0;
		
		for(int i = 1; i < s - 1; i++) {
			if(arr[i] == 'O' && arr[i + 1] == 'I') {
				memo[i + 1] = memo[i - 1] + 1;
				
				if(memo[i + 1] >= n && arr[i - 2 * n + 1] == 'I') {
					ans++;
				}
			}
		}
		
		System.out.println(ans);

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
