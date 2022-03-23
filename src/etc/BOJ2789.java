package etc;

import java.util.*;
import java.io.*;

public class BOJ2789 {

	static String name;
	static boolean isContain = false;
	static char[] ch = { 'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E' };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		name = br.readLine();
		for (int i = 0; i < name.length(); i++) {
			isContain = false;
			for (int j = 0; j < ch.length; j++) {
				if (name.charAt(i) == ch[j]) {
					isContain = true;
					break;
				}
			}

			if (!isContain) {
				System.out.print(name.charAt(i));
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
