package implementation;

import java.util.*;
import java.io.*;

public class BOJ11000 {

	static int n;
	static int map[][];

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[i][0] = a;
			map[i][1] = b;
		}

		Arrays.sort(map, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		pro();
	}

	static void pro() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(map[0][1]);

		for (int i = 1; i < n; i++) {
			if (queue.peek() <= map[i][0]) {
				queue.poll();
			}

			queue.add(map[i][1]);
		}
		
		System.out.println(queue.size());
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
