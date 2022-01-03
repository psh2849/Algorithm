package etc;

import java.util.Scanner;

public class BOJ10769 {
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		str = str.replace(":-)", "1");
		str = str.replace(":-(", "2");
		
		int smile = 0;
		int sad = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1') {
				smile++;
			} else if(str.charAt(i) == '2'){
				sad++;
			}
		}
		
		if(smile == 0 && sad == 0) {
			System.out.println("none");
		} else if(smile == sad) {
			System.out.println("unsure");
		} else if(smile > sad) {
			System.out.println("happy");
		} else {
			System.out.println("sad");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
