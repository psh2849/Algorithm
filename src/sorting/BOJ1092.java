package sorting;

import java.util.*;
import java.io.*;

public class BOJ1092 {

	static int n, m;
	static ArrayList<Integer> crane = new ArrayList<>();
	static ArrayList<Integer> box = new ArrayList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}

		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
	

		int time = 0;
		if (crane.get(0) < box.get(0)) {
			sb.append("-1");
			System.out.println(sb);
			return;
		} else {
			while(!box.isEmpty()) {
				int index = 0;
				for(int i = 0; i < crane.size();) {
					if(index == box.size()) break;
					else if(crane.get(i) >= box.get(index)) {
						box.remove(index);
						i++;
					} else {
						index++;
					}
				}
				
				time++;
			}
		}
		
		sb.append(time);
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
