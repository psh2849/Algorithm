package etc;

import java.util.*;
import java.io.*;

public class BOJ19583 {

	static String start, end, finish;
	static Set<String> before = new HashSet<>();
	static Set<String> after = new HashSet<>();
	static Set<String> answer = new HashSet<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = st.nextToken();
		end = st.nextToken();
		finish = st.nextToken();
	
		String input = null;
		while((input = br.readLine()) != null) {
			String[] arr = input.split(" ");
			String time = arr[0];
			String name = arr[1];
			
			answer.add(name);
			if(start.compareTo(time) >= 0) {
				before.add(name);
			} else if(end.compareTo(time) <= 0 && finish.compareTo(time) >= 0) {
				after.add(name);
			}
		}
		
		int result = 0;
		for(String name: answer) {
			if(before.contains(name) && after.contains(name)) {
				result++;
			}
		}
		
		System.out.println(result);
	}

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		input();
	}

}
