/*
 * https://moonsbeen.tistory.com/294
 */
package programmers_lv3;

import java.util.Stack;

public class PRO15 {

	static class Node {
		int prev;
		int cur;
		int next;

		public Node(int prev, int cur, int next) {
			this.prev = prev;
			this.cur = cur;
			this.next = next;
		}
	}

	static String solution(int n, int k, String[] cmd) {
		String answer = "";
		int[] prev = new int[n];
		int[] next = new int[n];

		for (int i = 0; i < n; i++) {
			prev[i] = i - 1;
			next[i] = i + 1;
		}
		next[n - 1] = -1;

		Stack<Node> stack = new Stack<>();
		StringBuilder sb = new StringBuilder("O".repeat(n));
		for (int i = 0; i < cmd.length; i++) {
			char ch = cmd[i].charAt(0);
			if (ch == 'D') {
				int num = Integer.valueOf(cmd[i].substring(2));
				while (num-- > 0) {
					k = next[k];
				}
			} else if (ch == 'U') {
				int num = Integer.valueOf(cmd[i].substring(2));
				while(num-- > 0) {
					k = prev[k];
				}
			} else if (ch == 'C') {
				stack.push(new Node(prev[k], k, next[k]));
				if(prev[k] != -1) next[prev[k]] = next[k];
				if(next[k] != -1) prev[next[k]] = prev[k];
				sb.setCharAt(k, 'X');
				if(next[k] != -1) k = next[k];
				else k = prev[k];
			} else if (ch == 'Z') {
				Node node = stack.pop();
				if(node.prev != -1) next[node.prev] = node.cur;
				if(node.next != -1) prev[node.next] = node.cur;
				sb.setCharAt(node.cur, 'O');
			}
		}
	
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
		solution(8, 2, cmd);
	}

}
