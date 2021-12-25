package etc;

import java.util.*;
import java.io.*;

public class BOJ4659 {
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			boolean isBool = false;
			
			if(str.equals("end")) {
				break;
			}
			
			if(!(str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u"))) {
				isBool = true;
			}
			
			for(int i = 0; i < str.length(); i++) {
				int mo = 0;
				int ja = 0;
				for(int j = 0; j < str.length(); j++) {
					if(str.charAt(j) == 'a' || str.charAt(j) == 'e' || str.charAt(j) == 'i' || str.charAt(j) == 'o' || str.charAt(j) == 'u') {
						mo++;
						ja = 0;
					} else {
						ja++;
						mo = 0;
					}
					
					if(mo == 3 || ja == 3) {
						isBool = true;
						break;
					}
				}
				
				if(isBool) {
					break;
				}
			}
			
			for(int i = 0; i < str.length() - 1; i++) {
				if(str.charAt(i) == 'e' || str.charAt(i) == 'o') {
					continue;
				}
				if(str.charAt(i) == str.charAt(i + 1)) {
					isBool = true;
				}
			}
			
			if(isBool) {
				System.out.println("<" + str + "> is not acceptable.");
			} else {
				System.out.println("<" + str + "> is acceptable.");
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
