package etc;

import java.util.*;
import java.io.*;

public class BOJ2566 {

	static void input() {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Deque<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		while (!queue.isEmpty()) {
			if(queue.size() == 1) {
				break;
			}
			int num = queue.pollFirst();
			System.out.println(num);

			queue.addLast(queue.pollFirst());
		}
		
		System.out.println(queue.poll());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
