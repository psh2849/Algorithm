package etc;

import java.util.*;
import java.io.*;

public class BOJ9324 {

	static int t;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String str = br.readLine();
			int[] arr = new int[26];
			
			boolean isFake = false;
			for(int i = 0; i < str.length(); i++) {
				arr[str.charAt(i) - 'A']++;
				
				if(arr[str.charAt(i) - 'A'] == 3 ) {
					if(i == str.length() - 1) {
						isFake = true;
						break;
					}
					
					if(str.charAt(i) != str.charAt(i + 1)) {
						isFake = true;
						break;
					}
					
					i++;
					arr[str.charAt(i) - 'A'] = 0;
				}
 			}
			
			System.out.println(isFake ? "FAKE" : "OK");
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
