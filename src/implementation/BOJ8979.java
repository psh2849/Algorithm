package implementation;

import java.util.*;
import java.io.*;

public class BOJ8979 {
	static class Medal {
		int idx;
		int gold;
		int silver;
		int bronze;
		int rank;
		
		public Medal(int idx, int gold, int silver, int bronze, int rank) {
			this.idx = idx;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rank = rank;
		}
	}

	static int n, k;
	static ArrayList<Medal> list = new ArrayList<>();
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			
			list.add(new Medal(idx, gold, silver, bronze, 1));
		}
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size(); j++) {
				if(i != j) {
					if(list.get(i).gold < list.get(j).gold) {
						list.get(i).rank++;
						continue;
					}
					if((list.get(i).gold == list.get(j).gold) 
							&& (list.get(i).silver < list.get(j).silver)) {
						list.get(i).rank++;
						continue;
					}
					
					if(list.get(i).gold == list.get(j).gold && 
							list.get(i).silver == list.get(j).silver &&
							list.get(i).bronze < list.get(j).bronze) {
						list.get(i).rank++;
						continue;
					}
				}
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).idx == k) {
				System.out.println(list.get(i).rank);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
