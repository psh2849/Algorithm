package implementation;

import java.util.*;
import java.io.*;

public class BOJ11497 {

	static int t, n;
	static int max;
	static int[] tree, answer;
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			tree = new int[n];
			answer = new int[n];
			max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(tree);
			
			int left = 0;
			int right = n - 1;
			for(int i = 0; i < n; i++) {
				if(i % 2 != 0) {
					answer[left] = tree[i];
					left++;
				} else {
					answer[right] = tree[i];
					right--;
				}
			}
			
			for(int i = 1; i < n; i++) {
				int sum = Math.abs(answer[i - 1] - answer[i]);
				max = Math.max(max, sum);
			}
			
			max = Math.max(Math.abs(answer[n - 1] - answer[0]), max);
			System.out.println(max);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		input();
	}
}
