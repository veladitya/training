package iamazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphNavigation {
	public static boolean isValid(String word) {
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("car");
		dict.add("tar");
		dict.add("tor");
		dict.add("toy");
		if (dict.contains(word))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(minTransforms(Arrays.asList(0, 1, 2), "cat", 0, "toy"));
	}

	public static int minTransforms(List<Integer> indxes, String word, int len, String dest) {
		if (word.equals(dest))
			return len;
		int lenT = Integer.MAX_VALUE;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == dest.charAt(i))
				continue;
			List<String> words = generateWords(i, word);
			List<Integer> ind = new ArrayList<>(indxes);
			for (String word_new : words) {
				if (!word_new.equals(word) && isValid(word_new)) {
					// ind.remove(indx);
					lenT = Math.min(minTransforms(ind, word_new, len + 1, dest), lenT);
				}
			}
		}
		return lenT;
	}

	public static List<String> generateWords(int indx, String word) {
		List<String> words = new ArrayList<String>();
		char chr[] = word.toCharArray();
		for (char a = 'a'; a <= 'z'; a++) {
			chr[indx] = a;
			String str = new String(chr);
			words.add(str);
		}
		return words;
	}
}
