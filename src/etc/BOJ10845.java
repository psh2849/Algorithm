package etc;

import java.util.*;
import java.io.*;

public class BOJ10845 {
	static Deque<Integer> queue = new LinkedList<>();
	static int n;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			
			if(str.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				
				queue.add(num);
			}
			else if(str.equals("front")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				
				System.out.println(queue.peekFirst());
			} 
			else if(str.equals("back")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				
				System.out.println(queue.peekLast());
			}
			else if(str.equals("pop")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				
				System.out.println(queue.pop());
			}
			else if(str.equals("size")) {
				System.out.println(queue.size());
			}
			else if(str.equals("empty")) {
				if(queue.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
