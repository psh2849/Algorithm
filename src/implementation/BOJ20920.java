package implementation;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ20920 {

	static int n, m;
	static HashMap<String, Integer> map = new HashMap<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.length() >= m) {
				map.put(str, map.getOrDefault(str, 0) + 1);
			}
		}

		List<String> word = map.keySet().stream().collect(Collectors.toList());
		word.sort((o1, o2) -> {
			int c1 = map.get(o1);
			int c2 = map.get(o2);
			
			if(c1 == c2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} 
				
				return o2.length() - o1.length();
			}
			
			return c2-c1;
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < word.size(); i++) {
			sb.append(word.get(i) + "\n");
		}
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
