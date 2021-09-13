package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4999 {
	static String m_talk, d_talk;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		m_talk = br.readLine();
		d_talk = br.readLine();
		
		pro();
		
	}
	
	static void pro() {
		if(m_talk.length() < d_talk.length()) {
			System.out.println("no");
			return;
		} else {
			if(m_talk.contains(d_talk)) {
				System.out.println("go");
				return;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		
	}

}
