package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ18870 {
	
	static int N;
	static int[] arr, arr2;
	static HashMap<Integer, Integer> map = new HashMap<>();
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arr2 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr2[i] = arr[i];
		}

		Arrays.sort(arr2);

		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(!map.containsKey(arr2[i])) {
				map.put(arr2[i], cnt);
				cnt++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(map.get(arr[i]) + " ");
		}
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
