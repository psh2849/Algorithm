/*
 * https://programmers.co.kr/learn/courses/30/lessons/12969
 */
package programmers_lv1;

import java.util.Scanner;

public class PRO46 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i = 0; i < b; i++) {
			for(int j = 0; j < a; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
