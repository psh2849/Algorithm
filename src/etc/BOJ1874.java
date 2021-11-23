package etc;

import java.util.*;
import java.io.*;

public class BOJ1874 {
	
	static int n;
	static Stack<Integer> stack = new Stack<>();
	static ArrayList<String> list = new ArrayList<>();
	static int[] arr;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			stack.push(i);
			list.add("+");
			
			while(!stack.isEmpty()) {
				if(stack.peek() == arr[cnt]) {
					stack.pop();
					list.add("-");
					cnt++;
				} else {
					break;
				}
			}
		}
		
		if(stack.isEmpty()) {
			for(String str : list) {
				System.out.println(str);
			}
		} else {
			System.out.println("NO");
		}
				

		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
