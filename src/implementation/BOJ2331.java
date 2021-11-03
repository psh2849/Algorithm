package implementation;

import java.util.*;
import java.io.*;

public class BOJ2331 {
	static String n;
	static int m;
	static int num = 0;
	static int answer = 0;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = st.nextToken();
		m = Integer.parseInt(st.nextToken());
		
		int value = Integer.parseInt(n);
		list.add(value);
		while (true) {
			num = 0;
			for (int i = n.length() - 1; i >= 0; i--) {
				num += Math.pow((n.charAt(i) - '0'), m);
			}
			n = String.valueOf(num);
			if (!list.contains(num)) {
				list.add(num);
			} else {
				break;
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) != num) {
				answer++;
			} else {
				break;
			}
		}
		
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
