package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10798 {
	static char[][] map;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[16][16];
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 16; j++) {
				map[i][j] = '-';
			}
		}
		
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 6; j++) {
				if(map[j][i] != '-') {
					System.out.print(map[j][i]);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
