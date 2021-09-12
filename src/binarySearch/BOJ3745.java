package binarySearch;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ3745 {

	static int N;
	static int arr[];
	static int dp[];
	static int max = Integer.MIN_VALUE;

	static void input() {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			N = sc.nextInt();
			arr = new int[N];
			ArrayList<Integer> list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			for (int num : arr) {
				if(list.size() == 0 || list.get(list.size() - 1) < num) {
					list.add(num);
				} else {
					int left = 0;
					int right = list.size() - 1;
					
					while(left < right) {
						int mid = (left + right) / 2;
						
						if(list.get(mid) < num) {
							left = mid + 1;
						} else {
							right = mid;
						}
					}
					
					list.set(right, num);
				}
			}
			
			System.out.println(list.size());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
