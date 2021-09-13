package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ20528 {
	static ArrayList<Character> list = new ArrayList<>();
	static int N;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			String str = st.nextToken();
			str = str.substring(str.length() - 1, str.length());
			list.add(str.charAt(0));
		}
		
		Collections.sort(list);
		for(int i = 0; i < list.size() - 1; i++) {
			if(list.get(i) != list.get(i + 1)) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		input();
	}

}
