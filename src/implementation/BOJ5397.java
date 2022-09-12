package implementation;

import java.util.*;
import java.io.*;

public class BOJ5397 {	
	
	static String str;
	static int n;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			str = br.readLine();
			
			StringBuilder sb = new StringBuilder();
			Stack<Character> pre = new Stack<>();
			Stack<Character> post = new Stack<>();
			
			
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '<') {
					if(!pre.isEmpty()) {
						post.push(pre.pop());
					}
				} 
				else if(str.charAt(j) == '>') {
					if(!post.isEmpty()) {
						pre.push(post.pop());
					}
				} 
				else if(str.charAt(j) == '-') {
					if(!pre.isEmpty()) {
						pre.pop();
					}
				} 
				else {
					pre.push(str.charAt(j));
				}
			}
		
			while(!post.isEmpty()) {
				pre.push(post.pop());
			}
			
			for(char ch : pre) {
				sb.append(ch);
			}
			
			System.out.println(sb);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
