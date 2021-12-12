package etc;

import java.util.*;
import java.io.*;

public class BOJ14425 {
	
	static int n, m;
	static HashMap<String, Boolean> map = new HashMap<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			
			map.put(str, true);
		}
		
		int cnt = 0;
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			
			if(map.containsKey(str)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
