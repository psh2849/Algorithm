package programmers_lv2;

public class PRO15 {
	
	static int solution(int[] arr) {
		int num = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			num = lcm(num, arr[i]);
			System.out.println(num);
		}
	
		return num;
	}
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
	
	static int lcm(int a, int b) {
		return a * b / gcd(a,b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,6,8,14};
		solution(arr);
	}

}
