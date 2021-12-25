package etc;

import java.util.*;
import java.io.*;

public class BOJ16171 {
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String find = br.readLine();
		
		String answer = "";
		
		for(int i = 0; i < str.length(); i++) {
			if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
				answer += str.charAt(i);
			}
		}
		
		if(answer.contains(find)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
