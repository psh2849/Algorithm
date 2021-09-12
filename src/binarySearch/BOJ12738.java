/*
 * 12738. ÀÌºÐÅ½»ö
 */
package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ12738 {
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();

	static void pro() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());

		list.add(0);

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (list.get(list.size() - 1) < num) {
				list.add(num);
			} else {
				int left = 1;
				int right = list.size() - 1;
				int mid = 0;
				while (left < right) {
					mid = (left + right) / 2;

					if (list.get(mid) < num) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				list.set(right, num);
			}

		}
		sb.append(list.size() - 1);
		System.out.println(sb);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		pro();
	}

}
