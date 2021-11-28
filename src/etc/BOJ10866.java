package etc;

import java.util.*;
import java.io.*;

public class BOJ10866 {
	
	static int n;
	static Deque<Integer> queue = new LinkedList<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if(str.equals("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				queue.addLast(num);
			}
			else if(str.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				queue.addFirst(num);
			}
			else if(str.equals("pop_front")) {
				if(!queue.isEmpty()) {
					System.out.println(queue.pollFirst());
				} else {
					System.out.println(-1);
				}
			}
			else if(str.equals("pop_back")) {
				if(!queue.isEmpty()) {
					System.out.println(queue.pollLast());
				} else {
					System.out.println(-1);
				}
			}
			else if(str.equals("front")) {
				if(!queue.isEmpty()) {
					System.out.println(queue.peekFirst());
				} else {
					System.out.println(-1);
				}
			}
			else if(str.equals("back")) {
				if(!queue.isEmpty()) {
					System.out.println(queue.peekLast());
				} else {
					System.out.println(-1);
				}
			}
			else if(str.equals("size")) {
				System.out.println(queue.size());
			}
			else if(str.equals("empty")) {
				if(!queue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
