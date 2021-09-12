package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2979 {

	static int[] arr = new int[101];

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			max = Math.max(max, y);
			for(int j = x; j < y; j++) {
				arr[j]++;
			}
		}
		
		int sum = 0;
		for(int i = 1; i < max; i++) {
			if(arr[i] == 1) {
				sum += a;
			} else if(arr[i] == 2) {
				sum += (b * 2);
			} else if(arr[i] == 3){
				sum += (c * 3);
			}
		}
		
		System.out.println(sum);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
