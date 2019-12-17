package iamazon.arrays;

import java.util.Arrays;

public class RemoveCharsToMakeAnagram {

	public static void main(String[] args) {
		String str = "bcadeh";
		String pat = "hea";
		char[] s = str.toCharArray();
		char[] p = pat.toCharArray();

		int n = findMinCharsToRemove(s, p, s.length, p.length);
		System.out.println("Minimum Chars to remove [" + n + "]");
	}

	static int findMinCharsToRemove(char[] s, char[] p, int sL, int pL) {
		int minChars = 0;
		int tmpPL = pL;
		for (int i = 0; i < sL; i++) {
			if (!isPresent(s[i], p)) {
				minChars++;
			}
		}
		return minChars + String.valueOf(p).replace("#", "").length();
	}

	static boolean isPresent(char c, char[] p) {

		for (int i = 0; i < p.length; i++) {
			if (p[i] == c) {
				p[i] = '#';
				return true;
			}
		}
		return false;
	}

}
