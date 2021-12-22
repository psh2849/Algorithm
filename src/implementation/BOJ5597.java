package implementation;

import java.util.*;

public class BOJ5597 {
	
	static boolean[] stu;
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		stu = new boolean[31];
		for(int i = 0; i < 28; i++) {
			int student = sc.nextInt();
			
			stu[student] = true;
		}
		
		for(int i = 1; i < 31; i++) {
			if(!stu[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
