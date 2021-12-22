package implementation;

import java.util.*;
import java.io.*;

public class BOJ2851 {

	static void input() {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int save = 0;
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			sum += num;
			if(sum >= 100) {
				if(Math.abs(sum - 100) > Math.abs(save - 100)) {
					System.out.println(save);
				} else {
					System.out.println(sum);
				}
				
				return;
			} 
			save = sum;
		}
		
		System.out.println(sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
