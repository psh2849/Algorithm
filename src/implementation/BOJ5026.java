package implementation;

import java.io.*;

public class BOJ5026 {

	static int n;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.equals("P=NP")) {
				System.out.println("skipped");
				continue;
			}

			String[] split = str.split("\\+");
			int num = Integer.parseInt(split[0]);
			int num2 = Integer.parseInt(split[1]);

			System.out.println(num + num2);

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
