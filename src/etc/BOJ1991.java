package etc;

import java.util.*;
import java.io.*;

public class BOJ1991 {

	static class Node {
		int left;
		int right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	static int n;
	static ArrayList<Node>[] list;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			String[] line = br.readLine().split(" ");
			int data = line[0].charAt(0) - 'A' + 1;
			int left = line[1].charAt(0) - 'A' + 1;
			int right = line[2].charAt(0) - 'A' + 1;

			list[data].add(new Node(left, right));
		}

		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
	}

	static void preorder(int start) {
		for (Node node : list[start]) {
			int left = node.left;
			int right = node.right;
			System.out.print((char) (start + 'A' - 1));
			if (left != -18)
				preorder(left);
			if (right != -18)
				preorder(right);
		}
	}

	static void inorder(int start) {
		for (Node node : list[start]) {
			int left = node.left;
			int right = node.right;
			if (left != -18)
				inorder(left);
			System.out.print((char) (start + 'A' - 1));
			if (right != -18)
				inorder(right);
		}
	}

	static void postorder(int start) {
		for (Node node : list[start]) {
			int left = node.left;
			int right = node.right;
			if (left != -18)
				postorder(left);
			if (right != -18)
				postorder(right);
			System.out.print((char) (start + 'A' - 1));
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
