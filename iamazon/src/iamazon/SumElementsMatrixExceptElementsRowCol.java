package iamazon;

// An efficient Java program to compute 
// sum for given array of cell indexes 
class SumElementsMatrixExceptElementsRowCol {
	static int R = 3;
	static int C = 3;

// A structure to represent a cell index 
	static class Cell {
		int r; // r is row, varies from 0 to R-1
		int c; // c is column, varies from 0 to C-1

		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	};

	static void printSums(int mat[][], Cell arr[], int n) {
		int sum = 0;
		int[] row = new int[R];
		int[] col = new int[C];

		// Compute sum of all elements,
		// sum of every row and sum every column
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += mat[i][j];
				col[j] += mat[i][j];
				row[i] += mat[i][j];
			}
		}

		// Compute the desired sum
		// for all given cell indexes
		for (int i = 0; i < n; i++) {
			int ro = arr[i].r, co = arr[i].c;
			System.out.println(sum - row[ro] - col[co] + mat[ro][co]);
		}
	}

// Driver Code 
	public static void main(String[] args) {
		int mat[][] = { { 1, 1, 2 }, { 3, 4, 6 }, { 5, 3, 2 } };
		Cell arr[] = { new Cell(0, 0), new Cell(1, 1), new Cell(0, 1) };
		int n = arr.length;
		printSums(mat, arr, n);
	}
}

// This code is contributed by Princi Singh 
