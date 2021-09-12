package sorting;

import java.util.Arrays;
import java.util.Scanner;

class Sequence implements Comparable<Sequence> {
	int num;
	int idx;
	
	public Sequence(int num, int idx) {
		this.num = num;
		this.idx = idx;
	}

	@Override
	public int compareTo(Sequence o) {
		// TODO Auto-generated method stub
		if(this.num != o.num) return this.num - o.num;
		return this.idx - o.idx;
	}
}
public class BOJ1015 {
	static int N;
	static Sequence[] B;
	static int[] P;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		B = new Sequence[N];
		P = new int[N];
		
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			
			B[i] = new Sequence(x, i);
		}
	}
	
	static void pro() {
		Arrays.sort(B);
		
		for(int i = 0 ; i < N; i++) {
			P[B[i].idx] = i;
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(P[i] + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
