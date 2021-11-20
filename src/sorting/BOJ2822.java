package sorting;

import java.util.*;
import java.io.*;

public class BOJ2822 {
	static class Score implements Comparable<Score>{
		int idx;
		int score;
		
		public Score(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}
		
		public int compareTo(Score o) {
			return o.score - this.score;
		}
	}
	
	static ArrayList<Score> score = new ArrayList<>();
	static ArrayList<Integer> copy = new ArrayList<>();
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 8; i++) {
			int num = Integer.parseInt(br.readLine());
			score.add(new Score(i + 1, num));
		}
		
		Collections.sort(score);
		
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			sum += score.get(i).score;
			copy.add(score.get(i).idx);
		}
		System.out.println(sum);
		
		Collections.sort(copy);
		for(int i = 0; i < copy.size(); i++) {
			System.out.print(copy.get(i) + " ");
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
