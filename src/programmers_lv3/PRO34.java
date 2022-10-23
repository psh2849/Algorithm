package programmers_lv3;

public class PRO34 {

	public static void main(String[] args) {
		solution(2554);
	}

	
	public static int solution(int storey) {
        return elevator(storey);
    }
	
	public static int elevator(int floor) {
		if (floor <= 1)
			return floor;

		int under10 = floor % 10;
		int rest = floor / 10;

		int c1 = under10 + elevator(rest);
		int c2 = (10 - under10) + elevator(rest + 1);
		
		System.out.println(c1 + " " + c2);
		return Math.min(c1, c2);
	}
}
