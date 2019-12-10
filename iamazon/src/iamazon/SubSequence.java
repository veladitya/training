package iamazon;

import java.util.SortedSet;
import java.util.TreeSet;

public class SubSequence {
	// set to store all the subsequences
	static SortedSet<String> st = new TreeSet<>();

	public static void subsequence(String str) {
		int count = str.length();

		for (int i = 0; i < count; i++) {
			for (int j = count; j > i; j--) {
				String sub_str = str.substring(i, j);

				if (!st.contains(sub_str))
					st.add(sub_str);

				for (int k = 0; k < sub_str.length(); k++) {
					StringBuffer sb = new StringBuffer(sub_str);
					sb.deleteCharAt(k);

					if (!st.contains(sb.toString()))
						st.add(sub_str);

					subsequence(sb.toString());
				}

			}
		}
	}

	public static void main(String args[]) {
		subsequence("abc");
		System.out.println(st);
	}
}
