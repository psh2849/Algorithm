package etc;

import java.util.*;

public class BOJ15904 {

	static void input() {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String answer = "";
		
		int cnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'U' && cnt == 0) {
				answer += 'U';
				cnt++;
			} else if(str.charAt(i) == 'C' && (cnt == 1 || cnt == 3)) {
				answer += 'C';
				cnt++;
			} else if(str.charAt(i) == 'P' && (cnt == 2)) {
				answer += 'P';
				cnt++;
			}
		}
		
		if(answer.contains("UCPC")) {
			System.out.println("I love UCPC");
		} else {
			System.out.println("I hate UCPC");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
