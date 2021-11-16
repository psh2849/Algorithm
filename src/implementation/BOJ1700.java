package implementation;

import java.util.*;
import java.io.*;

public class BOJ1700 {
	
	static int n, k;
	static boolean[] use;
	static int[] plug;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		plug = new int[k];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < k; i++) {
			plug[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
		
	}
	
	static void pro() {
		use = new boolean[101];
		
		int put = 0;
		int result = 0;
		for(int i = 0; i < k; i++) {
			int temp = plug[i];
			
			if(!use[temp]) {
				if(put < n) {
					use[temp] = true;
					put++;
				} else {
					ArrayList<Integer> list = new ArrayList<>();
					for(int j = i; j < k; j++) {
						if(use[plug[j]] && !list.contains(plug[j])) {
							list.add(plug[j]);
						}
					}
					
					if(list.size() != n) {
						for(int j = 0; j < use.length; j++) {
							if(use[j] && !list.contains(j)) {
								use[j] = false;
								break;
							}
						}
					} else {
						int remove = list.remove(list.size() - 1);
						use[remove] = false;
					}
					
					use[temp] = true;
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
