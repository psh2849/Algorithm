package etc;

import java.util.*;
import java.io.*;

public class BOJ10828 {
	
	static int n;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if(str.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}
			else if(str.equals("pop")) {
				if(stack.size() == 0) {
					System.out.println(-1);
					continue;
				}
				int num = stack.pop();
				System.out.println(num);
			}
			else if(str.equals("size")) {
				System.out.println(stack.size());
			}
			else if(str.equals("empty")) {
				if(stack.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
			else if(str.equals("top")) {
				if(stack.size() == 0) {
					System.out.println(-1);
					continue;
				}
				System.out.println(stack.peek());
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
