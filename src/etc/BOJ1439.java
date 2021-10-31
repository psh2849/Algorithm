package etc;

import java.util.*;
import java.io.*;

public class BOJ1439 {
	
	static boolean one = false, zero = false;
	static int oneCnt, zeroCnt;
	static String num;
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = br.readLine();
		char[] arr = num.toCharArray();
		if(arr[0] == '0') {
			zero = true;
			zeroCnt++;
		} else {
			one = true;
			oneCnt++;
		}
		for(int i = 0; i < arr.length; i++) {
			if(one && arr[i] == '0') {
				zeroCnt++;
				one = false;
				zero = true;
			} 
			else if(zero && arr[i] == '1') {
				oneCnt++;
				one = true;
				zero = false;
			}
		}
		System.out.println(Math.min(zeroCnt, oneCnt));
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		input();
	}

}
