package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1476 {
	
	static int earth, sun, moon;
	static int e =0, s= 0, m= 0;
	static int count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		earth = Integer.parseInt(st.nextToken());
		sun = Integer.parseInt(st.nextToken());
		moon = Integer.parseInt(st.nextToken());
		
		while(true) {
			if(e == earth && s == sun && m == moon) {
				System.out.println(count);
				break;
			}
			count++;
			e++;
			s++;
			m++;
			if(e == 16) {
				e = 1;
			}
			if(s == 29) {
				s = 1;
			}
			if(m == 20) {
				m = 1;
			}
		}
	}

}
