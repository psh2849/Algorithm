package sorting;

import java.util.*;
import java.io.*;

public class BOJ5576 {
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		Integer[] arr = new Integer[10];
		Integer[] arr2 = new Integer[10];
		
		for(int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}
		
		for(int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			arr2[i] = num;
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		Arrays.sort(arr2, Collections.reverseOrder());

		System.out.print(arr[0] + arr[1] + arr[2] + " ");
		System.out.println(arr2[0] + arr2[1] + arr2[2]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
