package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11403 {
	static int[][] map;
	static int N;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

	static void pro() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][k] == 1 && map[k][j] == 1) {
						map[i][j] = 1;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
