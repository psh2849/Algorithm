package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10988 {
	
	static String str;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		str = br.readLine();
		sb.append(str).reverse();
		if(str.equals(sb.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
