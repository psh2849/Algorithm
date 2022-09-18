package etc;

import java.util.*;
import java.io.*;

public class BOJ7785 {

	static int n;
	static HashMap<String, String> map = new HashMap<String, String>();
	static ArrayList<String> list = new ArrayList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String status = st.nextToken();

			map.put(name, status);
		}

		Iterator<String> status = map.keySet().iterator();
		while (status.hasNext()) {
			String key = status.next();

			// System.out.println(key + " " + map.get(key));

			if (map.get(key).equals("enter")) {
				list.add(key);
			}
		}

		Collections.sort(list, Comparator.reverseOrder());
		for (String name : list) {
			sb.append(name + "\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
