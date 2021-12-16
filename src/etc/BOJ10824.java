package etc;

import java.util.*;
import java.io.*;

public class BOJ10824 {
		
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		long num1 = Long.parseLong(str[0] + str[1]);
		long num2 = Long.parseLong(str[2] + str[3]);
		
		
		System.out.println(num1 + num2);
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
