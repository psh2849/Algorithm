package etc;

import java.util.*;

public class BOJ23795 {

	static void input() {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		while(true) {
			int num = sc.nextInt();
			if(num == -1) {
				break;
			}
			
			sum += num;
		}
		
		System.out.println(sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
