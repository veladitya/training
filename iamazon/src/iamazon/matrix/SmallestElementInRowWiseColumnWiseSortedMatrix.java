package iamazon.matrix;

import java.util.Stack;

public class SmallestElementInRowWiseColumnWiseSortedMatrix {

	static int smallestElement = 3;

	public static void main(String[] args) {
		// int[][] m = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 24, 29, 37, 48 }, {
		// 32, 33, 39, 50 } };
		int[][] m = { { 16, 28, 60, 64 }, { 22, 41, 63, 91 }, { 27, 50, 87, 93 }, { 36, 78, 87, 94 } };
		kthSmallest(m, 4, 7);
	}

	static void kthSmallest(int[][] a, int n, int k) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (s1.isEmpty()) {
					s1.push(a[i][j]);
					continue;
				}

				if (a[i][j] > s1.peek()) {
					s1.push(a[i][j]);
				} else {
					while (a[i][j] < s1.peek()) {
						s2.push(s1.peek());
						s1.pop();
					}

					s1.push(a[i][j]);
					while (!s2.isEmpty()) {
						s1.push(s2.pop());
					}
				}
			}
		}
		System.out.println(s1.get(k-1));
		
	}

}
