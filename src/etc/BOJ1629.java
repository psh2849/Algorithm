package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
	
	static long C;
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		long ans = pro(A, B);
		System.out.println(ans);
	}
	
	static long pro(long A, long exponent) {
		if(exponent == 1) {
			return A % C; 
		}
		
		long result = pro(A, exponent / 2);
		
		if(exponent % 2 == 1) {
			return ((result * result % C) * A) % C;
		}
		
		return result * result % C;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
