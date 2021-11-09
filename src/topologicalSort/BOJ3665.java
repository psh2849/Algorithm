package topologicalSort;

import java.util.*;
import java.io.*;

public class BOJ3665 {
	static int t, n, m;
	static int[] indeg;
	static boolean[][] edges;
	static ArrayList<Integer> list = new ArrayList<>();

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			indeg = new int[n + 1];
			edges = new boolean[n + 1][n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				indeg[num] = i;

				for (int j = 1; j <= n; j++) {
					if (j != num && !edges[j][num]) {
						edges[num][j] = true;
					}
				}
			}

			m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				swap(a, b);
				
			}
			bw.write(sort() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void swap(int a, int b) {
		if(edges[a][b]) {
			edges[a][b] = false;
			edges[b][a] = true;
			indeg[a]++;
			indeg[b]--;
		} else {
			edges[a][b] = true;
			edges[b][a] = false;
			indeg[a]--;
			indeg[b]++;
		}
	}
	
	static String sort() {
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= n; i++) {
			if(indeg[i] == 0) {
				queue.add(i);
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(queue.size() == 0) {
				return "IMPOSSIBLE";
			} else if(queue.size() > 1) {
				return "?";
			}
			
			int p = queue.poll();
			sb.append(p + " ");
			
			for(int j = 1; j <= n; j++) {
				if(edges[p][j]) {
					edges[p][j] = false;
					indeg[j]--;
					if(indeg[j] == 0) {
						queue.add(j);
					}
				}
			}
		}
		
		return sb.toString();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
