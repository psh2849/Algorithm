package implementation;

import java.util.*;
import java.io.*;

public class BOJ22233 {
	static int n, m;
	static HashSet<String> set = new HashSet<>();
	static HashSet<String> delete = new HashSet<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			set.add(str);
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			
			String[] splitStr = str.split(",");
			for (int j = 0; j < splitStr.length; j++) {
				if (set.contains(splitStr[j])) {
					if (!delete.contains(splitStr[j])) {
						delete.add(splitStr[j]);
					} 
				}
			}

			System.out.println(n - delete.size());
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
