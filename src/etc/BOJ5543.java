package etc;

import java.io.*;

public class BOJ5543 {
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = 2000;
		for(int i = 0; i < 3; i++) {
			int num = Integer.parseInt(br.readLine());
			min = Math.min(min, num);
		}
		
		int min2 = 2000;
		for(int i = 0; i < 2; i++) {
			int num = Integer.parseInt(br.readLine());
			min2 = Math.min(min2, num);
		}
		
		System.out.println(min + min2 - 50);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
