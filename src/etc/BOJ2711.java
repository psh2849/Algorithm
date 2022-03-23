package etc;

import java.util.*;
import java.io.*;

public class BOJ2711 {

	static int n;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()) - 1;
			String str = st.nextToken();
			
			for(int j = 0; j < str.length(); j++) {
				if(j == num) continue;
				System.out.print(str.charAt(j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
