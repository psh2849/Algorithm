package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1259 {

	static int num;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			num = Integer.parseInt(br.readLine());
			if (num == 0) {
				break;
			}

			if (pro()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	static boolean pro() {
		StringBuilder sb = new StringBuilder();
		sb.append(num);
		String s = sb.toString();
		return s.equals(sb.reverse().toString());
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
