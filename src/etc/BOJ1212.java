package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1212 {

	static String num;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		num = br.readLine();
		String result = pro();
		
		System.out.println(result);
	}

	static String pro() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < num.length(); i++) {
			String s = Integer.toBinaryString(num.charAt(i) - '0');
			if (s.length() == 2 && i != 0)
				s = "0" + s;
			else if(s.length() == 1 && i !=0) {
				s = "00" + s;
			}
			
			sb.append(s);
		}
		
		return sb.toString();
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}
}
