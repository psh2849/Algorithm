package etc;

import java.util.*;
import java.io.*;

public class BOJ2776 {
	
	static HashSet<Integer> set = new LinkedHashSet<>();
	static int n, t, m;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				set.add(num);
			}
			
			m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < m; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					bw.append("1\n");
				} else {
					bw.append("0\n");
				}
			}
			
			set.clear();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
