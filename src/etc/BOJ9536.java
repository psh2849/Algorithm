package etc;

import java.util.*;
import java.io.*;

public class BOJ9536 {
	
	static int n, cnt;
	static String record, str;
	static HashMap<String, Boolean> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		while(n --> 0) {
			sb = new StringBuilder();
			cnt = 0;
			HashMap<String, Boolean> map = new HashMap<>();
			
			while(true) {
				if(cnt == 0) {
					record = br.readLine();
				} else {
					str = br.readLine();
					if(str.equals("what does the fox say?")) {
						String[] split = record.split(" ");
						for(int i = 0; i < split.length; i++) {
							if(!map.containsKey(split[i])) {
								sb.append(split[i] + " ");
							}
						}
						
						System.out.println(sb);
						break;
					}
					
					String[] split = str.split(" ");
					map.put(split[2], true);
				}
				
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
