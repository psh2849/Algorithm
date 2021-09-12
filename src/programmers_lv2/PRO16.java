package programmers_lv2;

public class PRO16 {
	
	static int solution(int n) {
		int origin_cnt = Integer.bitCount(n);
		int next_cnt = 0;
		
		while(true) {
			n++;
			next_cnt = Integer.bitCount(n);
			if(origin_cnt == next_cnt) {
				return n;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(78);
	}

}
