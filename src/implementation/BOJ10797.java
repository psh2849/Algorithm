package implementation;

import java.util.*;
import java.io.*;

public class BOJ10797 {

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int day;
		int car;
		int ans = 0;
		day = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 5; i++) {
			car = Integer.parseInt(st.nextToken());
			
			if(car == day) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
