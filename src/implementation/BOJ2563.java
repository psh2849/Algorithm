package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {

	static int[][] arr;
	static int N, cnt;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[101][101];
		
		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int i = w; i < w + 10; i++) {
				for(int j = h; j < h + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
