package etc;

import java.util.*;
import java.io.*;

public class BOJ2845 {
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int weight = sc.nextInt();
		
		int result = num * weight;
		
		for(int i = 0; i < 5; i++) { 
			int a = sc.nextInt();
			System.out.print(a - result + " ");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
