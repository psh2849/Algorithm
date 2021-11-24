package etc;

import java.util.*;
import java.io.*;

public class BOJ6064 {

	static int t;
	static int m, n, x, y;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			
			boolean check = false;
			for (int j = x; j < (m * n); j += m) {
				if(j % n == y) {
					System.out.println(j + 1);
					check = true;
					break;
				}
			}
			
			if(!check) {
				System.out.println(-1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
