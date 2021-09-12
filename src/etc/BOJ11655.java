package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11655 {

	static String str = "";
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		
		pro();
	}

	static void pro() {
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				if(ch + 13 > 'z') {
					ch -= 13;
				} else {
					ch += 13;
				}
	
				System.out.print(ch);
			} else if(ch >= 'A' && ch <= 'Z') {
				if(ch + 13 > 'Z') {
					ch -= 13;
				} else {
					ch += 13;
				}
				System.out.print(ch);
			} else {
				System.out.print(ch);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
