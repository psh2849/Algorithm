package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3040 {
	
	static int[] arr;
	static boolean[] visit, ans;
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[10];
		visit = new boolean[10];
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0, 0);
		
		for(int i = 0; i < 9; i++) {
			if(ans[i]) {
				System.out.println(arr[i]);
			}
		}
	}
	
	static void dfs(int sum, int count) {
		if(sum == 100 && count == 7) {
			ans = visit.clone();
			return;
		} 
		
		for(int i = count; i < 9; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			dfs(sum + arr[i], count + 1);
			visit[i] = false;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		input();
	}

}

