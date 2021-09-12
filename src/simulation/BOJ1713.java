package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1713 {
	static class Student implements Comparable<Student> {
		int num;
		int idx;
		int recommend;

		public Student(int num, int idx, int recommend) {
			this.num = num;
			this.idx = idx;
			this.recommend = recommend;
		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			if (recommend > o.recommend) {
				return 1;
			}
			else if (recommend == o.recommend) {
				if (idx > o.idx) {
					return 1;
				}
			} 
			return -1;
		}

	}

	static int N, M;
	static int[] arr, answer;
	static ArrayList<Student> list = new ArrayList<>();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[101];
		for(int i = 1; i <= 100; i++) {
			arr[i] = 0;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			Collections.sort(list);
			int stu = Integer.parseInt(st.nextToken());
			arr[stu]++;
			
			if(arr[stu] > 1) {
				for(int j = 0; j < list.size(); j++) {
					if(list.get(j).num == stu) {
						list.get(j).recommend++;
						break;
					}
				}
			} else {
				N--;
				if(N < 0) {
					int saveName = list.get(0).num;
					arr[saveName] = 0;
					list.remove(0);
					list.add(new Student(stu, i, arr[stu]));
					N++;
				} else {
					list.add(new Student(stu, i, arr[stu]));
				}
			}
		}
		
		answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).num;
		}
		
		Arrays.sort(answer);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(answer[i] + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}
}
