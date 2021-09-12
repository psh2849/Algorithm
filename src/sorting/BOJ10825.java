/*
 * 10825. ±¹¿µ¼ö
 */
package sorting;

import java.util.Arrays;
import java.util.Scanner;

class Grade implements Comparable<Grade> {

	int kor, eng, math;
	String name;
	
	public Grade() {
		
	}
	public Grade(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	@Override
	public int compareTo(Grade o) {
		// TODO Auto-generated method stub
		if(this.kor != o.kor) return o.kor - this.kor;
		if(this.eng != o.eng) return this.eng - o.eng;
		if(this.math != o.math) return o.math - this.math;
		return this.name.compareTo(o.name);
	
	}

}
public class BOJ10825 {

	static int N;
	static String name;
	static int kor, eng, math;
	static Grade[] grade;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		grade = new Grade[N];
		for(int i = 0; i < N; i++) {
			name = sc.next();
			kor = sc.nextInt();
			eng = sc.nextInt();
			math = sc.nextInt();
			
			grade[i] = new Grade(name, kor, eng, math);
		}
	}
	
	static void pro() {
		Arrays.sort(grade);
		
		for(int i = 0 ; i < N; i++) {
			System.out.println(grade[i].name);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
