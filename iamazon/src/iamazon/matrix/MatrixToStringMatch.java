package iamazon.matrix;

public class MatrixToStringMatch {

	/**
	 * Check if a word exists in a grid or not
Given a 2D grid of characters and a word, the task is to check if that word exists in the grid or not. A word can be matched in 4 directions at any point.

The 4 directions are, Horizontally Left and Right, Vertically Up and Down.
	 * @param args
	 */
	public static void main(String[] args) {
		char matrixOfChars[][] = { 
				{ 'A', 'C', 'P', 'F' }, 
				{ 'X', 'S', 'O', 'P' }, 
				{ 'V', 'U', 'Q', 'N' },
				{ 'W', 'G', 'N', 'M' }, 
				{ 'D', 'A', 'T', 'I' } 
			};
		String word = "AGNI";
		int r = 5;
		int c = 4;
		if (checkMatch(matrixOfChars, word.toCharArray(), r, c))
			System.out.println("Yes");
		else
			System.out.println("No");

		// String res = find2(matrixOfChars, 5, 4, word);
		// System.out.println(res);
		// System.out.println(res.equals(word));

	}

	static boolean findmatch(char[][] matrixOfChars, char[] cs, int x, int y, int nrow, int ncol, int level) {
		int l = cs.length;

		// Pattern matched
		if (level == l)
			return true;

		// Out of Boundary
		if (x < 0 || y < 0 || x >= nrow || y >= ncol)
			return false;

		// If grid matches with a letter while
		// recursion
		if (matrixOfChars[x][y] == cs[level]) {

			// Marking this cell as visited
			char temp = matrixOfChars[x][y];
			matrixOfChars[x][y] = '#';

			// finding subpattern in 4 directions
			boolean res = findmatch(matrixOfChars, cs, x - 1, y, nrow, ncol, level + 1)
					| findmatch(matrixOfChars, cs, x + 1, y, nrow, ncol, level + 1)
					| findmatch(matrixOfChars, cs, x, y - 1, nrow, ncol, level + 1)
					| findmatch(matrixOfChars, cs, x, y + 1, nrow, ncol, level + 1);

			// marking this cell
			// as unvisited again
			matrixOfChars[x][y] = temp;
			return res;
		} else // Not matching then false
			return false;
	}

	// Function to check if the word exists in the grid or not
	static boolean  checkMatch(char[][] matrixOfChars, char[] cs, int rows, int cols) 
	{ 
	
	 int l = cs.length; 
	
	 // if total characters in matrix is 
	 // less then pattern lenghth 
	 if (l > rows * cols) 
	     return false; 
	
	 // Traverse in the grid 
	 for (int i = 0; i < rows; i++) { 
	     for (int j = 0; j < cols; j++) { 
	
	         // If first letter matches, then recur and check 
	         if (matrixOfChars[i][j] == cs[0]) 
	             if (findmatch(matrixOfChars, cs, i, j, rows, cols, 0)) 
	                 return true; 
	     } 
	 } 
	 return false; 
	}
}