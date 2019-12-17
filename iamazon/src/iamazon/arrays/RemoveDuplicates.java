package iamazon.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicates {

	public static Integer[] removeDuplicates(int[] arr) {
		int size = arr.length;
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < size; i++) {
			if (!set.contains(arr[i])) {
				set.add(arr[i]);
			}
		}

		set.toArray();
		size = set.size();
		arr = new int[size];

		Iterator<Integer> itr = set.iterator();
		int i = 0;
		while (itr.hasNext()) {
			arr[i++] = itr.next();
		}

		return set.toArray(new Integer[set.size()]);
	}

	public static void main(String[] args) {
		Integer[] arr = removeDuplicates(new int[] { 1, 2, 3, 2, 1, 1 });
		System.out.println(Arrays.toString(arr));
	}
}
