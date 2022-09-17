package implementation;

import java.io.*;
import java.util.*;

public class BOJ9017 {

	static int t;
	static int n;

	static int[] arr, save;
	static int[] count;
	static int[] whenArriveFive;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			arr = new int[201];
			save = new int[n + 1];
			count = new int[201];
			whenArriveFive = new int[201];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				save[i] = num;
				count[num]++;

				if (count[num] == 5) {
					whenArriveFive[num] = i;
				}
			}
		
			int cnt = 1;
			int[] check = new int[201];
			for(int i = 1; i <= n; i++) {
				int num = save[i];
				
				if(count[num] >= 6) {
					if(check[num] < 4) {
						arr[num] += cnt;
					}
					
					check[num]++;
					cnt++;
				}
			}
			
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= 200; i++) {
				if (min > arr[i] && count[i] >= 6) {
					min = Math.min(min, arr[i]);
				}
			}

			int rank = Integer.MAX_VALUE;
			for (int i = 1; i <= 200; i++) {
				if (arr[i] == min && count[i] >= 6) {
					rank = Math.min(rank, whenArriveFive[i]);
				}
			}

			for (int i = 1; i <= 200; i++) {
				if (rank == whenArriveFive[i] && count[i] >= 6) {
					System.out.println(i);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
