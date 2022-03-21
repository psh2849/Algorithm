package sorting;

import java.util.*;
import java.io.*;

public class BOJ9076 {

	static int t;
	static int[] list;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			list = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 5; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(list);
			
			int sum = 0;
			
			if(list[1] + 4 <= list[4]) {
				System.out.println("KIN");
			} else {
				for(int i = 1; i < 4; i++) {
					sum += list[i];
				}
				
				System.out.println(sum);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
