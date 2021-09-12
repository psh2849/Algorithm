package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3046 {
	
	static int R1, avg;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R1 = Integer.parseInt(st.nextToken());
		avg = Integer.parseInt(st.nextToken());
	
		System.out.println(avg * 2 - R1);
		
	}
}
