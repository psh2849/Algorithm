package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ6996 {

	static class Name {
		String str;

		public Name(String str) {
			this.str = str;
		}
	}

	static int n;

	static void input() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			boolean isBool = false;
			String str = sc.next();
			String str2 = sc.next();
			char[] arr1 = new char[str.length()];
			char[] arr2 = new char[str2.length()];
			
			if(str.length() != str2.length()) {
				System.out.println(str + " & " + str2 + " are NOT anagrams.");
				continue;
			}
			
			for(int j = 0; j < str.length(); j++) {
				arr1[j] = str.charAt(j);
			}
			
			for(int j = 0; j < str2.length(); j++) {
				arr2[j] = str2.charAt(j);
			}
			
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			
			String changeStr = "";
			String changeStr2 = "";
			for(int j = 0; j < arr1.length; j++) {
				changeStr += arr1[j];
			}
			
			for(int j = 0; j < arr2.length; j++) {
				changeStr2 += arr2[j];
			}
			
			if(changeStr2.contains(changeStr)) {
				isBool= true;
			}
			
			if(isBool) {
				System.out.println(str + " & " + str2 + " are anagrams.");
			} else {
				System.out.println(str + " & " + str2 + " are NOT anagrams.");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
