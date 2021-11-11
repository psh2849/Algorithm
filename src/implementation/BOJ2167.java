package implementation;

import java.io.*;
import java.util.*;

public class BOJ2167 {
	static int n,m,k;
	static int[][] map;
	static int[][] arr;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][m + 1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= m; j++ ) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		k = Integer.parseInt(br.readLine());
		arr = new int[k][4];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			for(int z = arr[i][0]; z <= arr[i][2]; z++) {
				for(int z1 = arr[i][1]; z1 <= arr[i][3]; z1++) {
					sum += map[z][z1];
				}
			}
			
			System.out.println(sum);
		}
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
