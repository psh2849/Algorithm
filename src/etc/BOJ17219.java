package etc;

import java.io.*;
import java.util.*;

public class BOJ17219 {

	static HashMap<String, String> map = new HashMap<>();
	static int n, m;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String site = st.nextToken();
			String password = st.nextToken();

			map.put(site, password);
		}

		for (int i = 0; i < m; i++) {
			String site = br.readLine();
			String answer = map.get(site);
			sb.append(answer + "\n");
		}
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
