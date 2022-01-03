package etc;

import java.util.*;
import java.io.*;

public class BOJ5637 {
	
	static String text;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		String answer = "";
		
		outer:
		while(true) {
			String[] str = br.readLine().trim().split(" ");
			
			for(int i = 0; i < str.length; i++) {
				str[i] = str[i].replaceAll("[^a-zA-Z-]", " ").trim();
				String[] temp = str[i].split(" ");
				for(int j = 0; j < temp.length; j++) {
					if(temp[j].equals("E-N-D")) {
						break outer;
					}
					
					if(temp[j].length() > max) {
						max = temp[j].length();
						answer = temp[j].toLowerCase();
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
