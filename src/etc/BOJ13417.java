package etc;

import java.util.*;
import java.io.*;

public class BOJ13417 {

	static int t;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int num = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			String[] split = str.split(" ");
			Arrays.sort(split);
			for(int i = 0; i < split.length; i++) {
				System.out.print(split[i] + " ");
			}
			System.out.println();
			
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
