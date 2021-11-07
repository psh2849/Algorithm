package etc;

import java.util.*;
import java.io.*;

public class BOJ5052 {

	static int t, n;
	static String[] phone;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			phone = new String[n];
			for (int i = 0; i < n; i++) {
				phone[i] = br.readLine();
			}
			Arrays.sort(phone);
			boolean isBool = pro();
			if (isBool) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	static boolean pro() {
		for (int i = 0; i < phone.length - 1; i++) {
			if (phone[i + 1].startsWith(phone[i])) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
