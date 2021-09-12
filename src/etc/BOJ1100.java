package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1100 {

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();

			if (i % 2 == 0) {
				for (int j = 0; j < 8; j++) {
					if (j % 2 == 0 && str.charAt(j) == 'F') {
						cnt++;
					}
				}
			} else {
				for (int j = 1; j < 8; j++) {
					if (j % 2 != 0 && str.charAt(j) == 'F') {
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
