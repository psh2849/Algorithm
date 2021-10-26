package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1543 {

	static String originWord, findWord;
	static int answer = 0;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		originWord = br.readLine();
		findWord = br.readLine();

		originWord = originWord.replace(findWord, ".");

		for (int i = 0; i < originWord.length(); i++) {
			if (originWord.charAt(i) == '.') {
				answer++;
			}
		}
		
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
