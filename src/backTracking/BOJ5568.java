package backTracking;

import java.util.*;
import java.io.*;

public class BOJ5568 {
	
	static int n, k;
	static String[] arr;
	static HashSet<String> set = new HashSet<String>();
	static boolean[] visit;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		visit = new boolean[n];
		arr = new String[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		pro(k, "");
		
		System.out.println(set.size());
		
		
	}
	
	static void pro(int count, String s) {
		if(count == 0) {
			set.add(s);
			return;
		} else {
			for(int i = 0; i < n; i++) {
				if(!visit[i]) {
					visit[i] = true;
					pro(count-1, s + arr[i]);
					visit[i] = false;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
