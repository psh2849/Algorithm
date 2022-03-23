package etc;

import java.util.*;
import java.io.*;

public class BOJ2857 {
	
	static String[] name = new String[5];
	static boolean isName = false;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 5; i++) {
			name[i] = br.readLine();
			
			if(name[i].contains("FBI")) {
				System.out.print(i + 1 + " ");
				isName = true;
			}
		}
		
		if(!isName) {
			System.out.println("HE GOT AWAY!");
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
