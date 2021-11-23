package implementation;

import java.util.*;
import java.io.*;

public class BOJ1138 {
	
	static int n, num;
	static int[] height;
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		height = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++) {
				if(num == 0 && height[j] == 0) {
					height[j] = i;
					break;
				} 
				else if(height[j] == 0) {
					num--;
				}
			}
		}
		
		for(int i = 0; i < height.length; i++) {
			System.out.print(height[i] + " ");
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		input();
	}

}
