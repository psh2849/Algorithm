package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {
	static int N;
	static int[] list;
	static StringBuilder sb = new StringBuilder();
	static int[] min;
	static boolean flag = false;
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		min = new int[3];
		min[0] = Integer.MAX_VALUE;
		list = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void pro() {
		int left = 0;
		int right = N - 1;

		while (left < right) {
			int value = list[left] + list[right];
			
			if(Math.abs(min[0]) > Math.abs(value)) {
				min[0] = value;
				min[1] = list[left];
				min[2] = list[right];
			}
			
			if (value == 0) {
				flag = true;
				sb.append(list[left] + " " + list[right]);
				break;
			} else if (value < 0) {
				left++;
			} else {
				right--;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		pro();
		
		if(flag == true) {
			System.out.println(sb);
		} else {
			System.out.println(min[1] + " " + min[2]);
		}
	}

}
