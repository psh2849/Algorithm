package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2529 {

	static int k;
	static char[] ch = new char[10];
	static boolean[] visit = new boolean[10];
	static ArrayList<String> result = new ArrayList<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int j = 0; j < k; j++) {
			ch[j] = st.nextToken().charAt(0);
		}

		dfs("", 0);
		Collections.sort(result);
		System.out.println(result.get(result.size() - 1));
		System.out.println(result.get(0));
	}

	static void dfs(String str, int count) {
		if (count == k + 1) {
			result.add(str);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (visit[i])
				continue;
			if (count == 0 || check(Character.getNumericValue(str.charAt(count - 1)), i, ch[count - 1])) {
				visit[i] = true;
				dfs(str + i, count + 1);
				visit[i] = false;
			}
		}
	}

	static boolean check(int a, int b, char op) {
		if(op == '<') {
			if(a < b) return true;
		} else {
			if(a > b) return true;
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
