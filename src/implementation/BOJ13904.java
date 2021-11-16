package implementation;

import java.util.*;
import java.io.*;

public class BOJ13904 {

	static class Assignment {
		int day;
		int score;

		public Assignment(int day, int score) {
			this.day = day;
			this.score = score;
		}
	}
	
	static int n, maxDay, answer;
	static ArrayList<Assignment> list = new ArrayList<>();
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			maxDay = Math.max(maxDay, a);
			list.add(new Assignment(a, b));
		}
		
		for(int i = maxDay; i > 0; i--) {
			answer += pro(i);
		}
		
		System.out.println(answer);
	}
	
	static int pro(int now) {
		int idx = -1;
		int result = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).day >= now && result < list.get(i).score) {
				idx = i;
				result = list.get(i).score;
			}
		}
		
		if(result == 0) {
			return 0;
		}
		
		list.remove(idx);
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		input();
	}

}
