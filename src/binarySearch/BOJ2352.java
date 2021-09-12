package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2352 {
	
	static int N;
	static int[] arr;
	static int[] list;
	static StringBuilder sb = new StringBuilder();
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i =0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void pro() {
		list[0] = arr[0];
		int idx = 1;
		int tmp = 0;
		for(int i = 1; i < N; i++) {
			if(list[idx-1] < arr[i]) {
				list[idx++] = arr[i];
			} else if(list[0] > arr[i]) {
				list[0] = arr[i];
			} else {
				tmp = Arrays.binarySearch(list, 0, idx, arr[i]);
				tmp = (tmp < 0) ? -tmp-1 : tmp;
				list[tmp] = arr[i];
			}
		}
		sb.append(idx);
		System.out.println(sb);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}

