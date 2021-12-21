package sorting;

import java.util.*;
import java.io.*;

public class BOJ5800 {

	static int n;
	static int cnt = 1;
	static int[] arr;
	static Integer[] dist;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			arr = new int[num];
			dist = new Integer[num - 1];
			for (int j = 0; j < num; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			for (int j = 0; j < num - 1; j++) {
				dist[j] = arr[j + 1] - arr[j];
			}
			
			Arrays.sort(dist, Collections.reverseOrder());
			System.out.println("Class " + cnt);
			System.out.println("Max " + arr[num - 1] + ", Min " + arr[0] + ", Largest gap " + dist[0]);
			cnt++;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
