package sorting;

import java.util.*;
import java.io.*;

public class BOJ1302 {
	
	static int n;
	static HashMap<String, Integer> map = new HashMap<>();
	static ArrayList<String> list;
	static void input() throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			
			if(!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.replace(str, map.get(str) + 1);
			}
		}
		
		int max = 0;
		for(String str : map.keySet()) {
			max = Math.max(map.get(str), max);
		}
		
		list = new ArrayList<String>(map.keySet());
		Collections.sort(list);
		
		for(String str : list) {
			if(map.get(str) == max) {
				System.out.println(str);
				break;
			}
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}	

}
