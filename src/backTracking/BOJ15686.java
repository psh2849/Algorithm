/*
 * 15686. 치킨 배달
 */
package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class House {
	int x;
	int y;

	public House(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ15686 {

	static int N, M;
	static int[][] map;
	static boolean[] visit;
	static ArrayList<House> house;
	static ArrayList<House> chicken;
	static Stack<House> stack;
	static int minDist = Integer.MAX_VALUE;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		map = new int[N + 1][N + 1];
		
		house = new ArrayList<House>();
		chicken = new ArrayList<House>();
		stack = new Stack<House>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					house.add(new House(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new House(i, j));
				}
			}
		}
		
		pro(0, 0);
		
		sb.append(minDist);
		System.out.println(sb);
		
	}

	static void pro(int start, int count) {
		if (count == M) {
			cal();
		} else {
			for (int i = start; i < chicken.size(); i++) {
				stack.push(chicken.get(i));
				pro(i + 1, count + 1);
				stack.pop();
			}
		}
	}

	static void cal() {
		int sum = 0;
		for (House home : house) {
			int min = Integer.MAX_VALUE;
			for (House chickens : stack) {
				int dist = Math.abs(home.x - chickens.x) + Math.abs(home.y - chickens.y);
				min = Math.min(dist, min);
			}
			sum += min;
			
			if(sum > minDist) {
				return;
			}
		}
		
		minDist = Math.min(sum, minDist);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
