package etc;

import java.io.*;

public class BOJ1343 {
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		str = str.replace("XXXX", "AAAA");
		str = str.replace("XX", "BB");
		
		if(str.contains("X")) {
			System.out.println(-1);
		} else {
			System.out.println(str);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
