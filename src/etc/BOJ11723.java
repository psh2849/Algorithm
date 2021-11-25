package etc;

import java.util.*;
import java.io.*;

public class BOJ11723 {

	static int n;
	static LinkedList<Integer> list = new LinkedList<>();
	static LinkedList<Integer> allList = new LinkedList<>();

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= 20; i++) {
			allList.add(i);
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String ch = st.nextToken();

			if (ch.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				if (!list.contains(num)) {
					list.add(num);
				}
			} else if (ch.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				if (list.contains(num)) {
					for (int j = 0; j < 20; j++) {
						if (list.get(j) == num) {
							list.remove(j);
							break;
						}
					}
				}
			} else if (ch.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if (list.contains(num)) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (ch.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if (list.contains(num)) {
					for (int j = 0; j < 20; j++) {
						if (list.get(j) == num) {
							list.remove(j);
							break;
						}
					}
				} else {
					list.add(num);
				}
			} else if (ch.equals("all")) {
				list.clear();
				list.addAll(allList);
			} else if (ch.equals("empty")) {
				list.clear();
			}
		}

		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
