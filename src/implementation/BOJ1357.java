package implementation;

import java.util.*;
import java.io.*;

public class BOJ1357 {
	
	static int x, y;
	
	static void input() throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		int revX = reverse(x);
		int revY = reverse(y);
		int answer = reverse(revX + revY);
		
		System.out.println(answer);
	}
	
	static int reverse(int x) {
		Queue<Integer> queue = new LinkedList<>();
		int result = 0;
		int cnt = -1;
		while(x > 0) {
			int num = x % 10;
			x = x/ 10;
			queue.add(num);
			cnt++;
		}
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			result += num * Math.pow(10, cnt);
			cnt--;
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
