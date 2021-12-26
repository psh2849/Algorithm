package etc;

import java.util.*;
import java.io.*;

public class BOJ13417 {

	static int t;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int num = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			ArrayList<String> list = new ArrayList<>();
			String[] split = str.split(" ");
			
			for(int i = 0; i < split.length; i++) {
				if(i == 0) {
					list.add(split[0]);
				} else {
					if(list.get(0).compareTo(split[i]) < 0) {
						list.add(split[i]);
					} else {
						list.add(0, split[i]);
					}
				}
			}
			
			for(int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
