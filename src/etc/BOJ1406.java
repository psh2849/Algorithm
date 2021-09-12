package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ1406 {

	static String str;
	static int M;
	static LinkedList<Character> list = new LinkedList<>();
	static ListIterator<Character> iter;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		str = br.readLine();
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		iter = list.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
	
		for (int i = 0; i < M; i++) {
			String command = br.readLine();
			char ch = command.charAt(0);
			if (ch == 'L') {
				if(iter.hasPrevious()) {
					iter.previous();
				}
			} 
			else if (ch == 'D') {
				if(iter.hasNext()) {
					iter.next();
				}
			} 
			else if (ch == 'B') {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			} 
			else if (ch == 'P') {
				char c = command.charAt(2);
				iter.add(c);
			}
		}

		for(Character chr : list) {
			bw.write(chr);
		}
		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
