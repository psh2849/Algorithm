package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1009 {

	static long[] arr;
	static int T;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cnt = 1;
		
		for(int i = 0; i < b; i++) {
			cnt = (cnt * a) % 10;
		}
		if(cnt == 0) {
			cnt = 10;
		}

		System.out.println(cnt);
		
		
	}

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			input();
		}
	}

}
