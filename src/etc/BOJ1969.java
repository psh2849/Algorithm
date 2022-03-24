package etc;

import java.util.*;
import java.io.*;

public class BOJ1969 {

	static int n, m, ans;
	static String[] str;
	static int[] cnt;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}

		for (int i = 0; i < m; i++) {
			cnt = new int[4];
			for (int j = 0; j < n; j++) {
				if (str[j].charAt(i) == 'A') {
					cnt[0]++;
				} else if (str[j].charAt(i) == 'C') {
					cnt[1]++;
				} else if (str[j].charAt(i) == 'G') {
					cnt[2]++;
				} else {
					cnt[3]++;
				}
			}
			
			int max = 0;
			int idx = 0;
			for(int z = 0; z < 4; z++) {
				if(cnt[z] > max || (cnt[z] == max && z < idx)) {
					max = cnt[z];
					idx = z;
				}
			}
			
			if(idx == 0) {
				sb.append('A');
			} else if(idx == 1) {
				sb.append('C');
			} else if(idx == 2) {
				sb.append('G');
			} else {
				sb.append('T');
			}
			
			ans += n - max;
		}

		System.out.println(sb);
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
