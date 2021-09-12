package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2947 {
	
	static int[] arr = new int[5];
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
	}
	
	static void pro() {
		while(isOk()) {
			for(int i = 0; i < 4; i++) {
				swap(i, i + 1);
			}
		}
	}
	
	static void swap(int a, int b) {
		if(arr[a] > arr[b]) {
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
			
			for(int i = 0; i < 5; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
	static boolean isOk() {
		for(int i = 0; i < 5; i++) {
			if(arr[i] != i + 1) {
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
