package implementation;

import java.util.*;
import java.io.*;

public class BOJ1027 {

	static int n, answer = 0;
	static double[] arr;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new double[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			int count = 0;
			double next = 0;

			for (int j = i - 1; j >= 0; j--) {
				double num = (arr[i] - arr[j]) / (i - j);
				if(j == i - 1 || next > num) {
					next = num;
					count++;
				}
				
			}

			next = 0;
			for (int j = i + 1; j < n; j++) {
				double num = (arr[j] - arr[i]) / (j - i);
				if(j == i + 1 || next < num) {
					next = num;
					count++;
				}
			}
			
			answer = Math.max(answer, count);
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
