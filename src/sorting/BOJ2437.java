package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2437 {
	static int N;
	static ArrayList<Integer> arr = new ArrayList<>();
	static int cnt = 0;
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr.add(num);
		}
	}
	
	static void pro() {
		Collections.sort(arr);
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(sum + 1 < arr.get(i)) {
				break;
			}
			
			sum += arr.get(i);
		}
		
		System.out.println(sum + 1);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}
}
