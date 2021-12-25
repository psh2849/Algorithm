package etc;

import java.util.*;
import java.io.*;

public class BOJ2204 {
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				return;
			}
			String[] str = new String[num];
			
			for(int i = 0; i < num; i++) {
				str[i] = br.readLine();
			}
			
			Arrays.sort(str, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.toLowerCase().compareTo(o2.toLowerCase());
				}
			});
			
			System.out.println(str[0]);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
