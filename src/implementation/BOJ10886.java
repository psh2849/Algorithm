package implementation;

import java.util.*;
import java.io.*;

public class BOJ10886 {

	static int n;

	static void input() throws IOException {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();

			if (num == 1) {
				cnt1++;
			} else {
				cnt2++;
			}
		}

		if (cnt1 < cnt2) {
			System.out.println("Junhee is not cute!");
		} else if(cnt1 > cnt2) {
			System.out.println("Junhee is cute!");
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
