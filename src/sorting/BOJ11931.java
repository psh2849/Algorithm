package sorting;

import java.util.*;
import java.io.*;

public class BOJ11931 {

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		for(Integer num : arr) {
			bw.append(num + "\n");
		}
		
		bw.flush();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
