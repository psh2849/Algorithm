package etc;

import java.util.*;
import java.io.*;

public class BOJ1158 {
	
	static int n, k;
	static Queue<Integer> queue = new LinkedList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			for(int i = 0; i < k - 1; i++) {
				int num =queue.poll();
				queue.add(num);
			}
			
			int p = queue.poll();
			list.add(p);
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(i == 0) {
				System.out.print("<");
			}
			
			if(i == list.size() - 1) {
				System.out.print(list.get(i) + ">");
			} else {
				System.out.print(list.get(i) + ", ");
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
