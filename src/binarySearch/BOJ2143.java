package binarySearch;

import java.util.*;
import java.io.*;

public class BOJ2143 {
	
	static int t, n, m;
	static long[] A, B;
	static ArrayList<Long> sumA, sumB;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		
		A = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		m = Integer.parseInt(br.readLine());
		B = new long[m];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		sumA = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			long temp = A[i];
			sumA.add(temp);
			for(int j = i + 1; j < n; j++) {
				temp += A[j];
				sumA.add(temp);
			}
		}
		
		sumB = new ArrayList<>();
		for(int i = 0; i < m; i++) { 
			long temp = B[i];
			sumB.add(temp);
			
			for(int j = i + 1; j < m; j++) {
				temp += B[j];
				sumB.add(temp);
			}
		}
		
		Collections.sort(sumA);
		Collections.sort(sumB);
		
		long ans = pro();
		System.out.println(ans);
	}
	
	static long pro() {
		int sizeA = sumA.size();
		int sizeB = sumB.size();
		int left = 0;
		int right = sizeB - 1;
		long answer = 0;
		
		while(left < sizeA && right >= 0) {
			long a = sumA.get(left);
			long b = sumB.get(right);
			long sum = a + b;
			
			if(sum == t) {
				long aCnt = 0;
				long bCnt = 0;
				
				while(left < sizeA && sumA.get(left) == a) {
					aCnt++;
					left++;
				}
				
				while(right >= 0 && sumB.get(right) == b) {
					bCnt++;
					right--;
				}
				
				answer += aCnt * bCnt;
			}
			
			else if(sum < t) {
				left++;
			} 
			
			else if(sum > t) {
				right--;
			}
		}
		
		return answer;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
