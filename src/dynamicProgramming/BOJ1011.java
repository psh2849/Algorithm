package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1011 {

	static int T;
	static int result;
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pro(x, y);
			System.out.println(result);
		}
	}

	static void pro(int x, int y) {
		int dist = y - x;
		double max = Math.round(Math.sqrt(dist));
		
		if(Math.pow(max, 2) >= dist) {
			result = (int) max * 2 - 1;
		} else {
			result = (int) max * 2;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
