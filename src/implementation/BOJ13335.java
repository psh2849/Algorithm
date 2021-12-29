package implementation;

import java.util.*;
import java.io.*;

public class BOJ13335 {

	static int n, m, l;
	static int[] bus;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		bus = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			bus[i] = Integer.parseInt(st.nextToken());
		}

		pro();
	}

	static void pro() {
		Queue<Integer> queue = new LinkedList<>();
		int time = 0;
		int weight = 0;

		for (int i = 0; i < n; i++) {
			while (true) {
				if (queue.isEmpty()) {
					queue.add(bus[i]);
					time++;
					weight += bus[i];
					break;
				} else if (queue.size() == m) {
					weight -= queue.remove();
				} else {
					if (weight + bus[i] > l) {
						queue.add(0);
						time++;
					} else {
						queue.add(bus[i]);
						time++;
						weight += bus[i];
						break;
					}
				}
			}
		}

		System.out.println(time + m);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
