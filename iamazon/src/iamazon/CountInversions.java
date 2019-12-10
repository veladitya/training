package iamazon;

import java.util.Arrays;

public class CountInversions {

	public static void main(String[] args) {
		System.out.println(mergeSortAndCount(new int[] { 1, 20, 6, 4, 5 }, 0, 4));
		System.out.println(mergeSort(new int[] { 1, 20, 6, 4, 5 }, 0, 4));
	}

	public static int mergeSortAndCount(int[] arr, int low, int high) {

		int count = 0;

		if (low < high) {
			int mid = (low + high) / 2;
			count += mergeSortAndCount(arr, low, mid);
			count += mergeSortAndCount(arr, mid + 1, high);
			// Merge count
			count += mergeAndCount(arr, low, mid, high);
		}

		return count;
	}

	public static int mergeSort(int[] arr, int low, int high) {

		int count = 0;

		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			// Merge count
			merge(arr, low, mid, high);
		}

		return count;
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		/* Create temp arrays */
		int[] left = Arrays.copyOfRange(arr, low, mid + 1);
		int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);


		int i = 0, j = 0, swaps = 0, k = low;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k] = left[i++];
			} else {
				arr[k] = right[j++];
				swaps += (mid + 1) - (low + i);
			}
			k++;
		}

		// Fill from the rest of the left subarray
		while (i < left.length)
			arr[k++] = left[i++];

		// Fill from the rest of the right subarray
		while (j < right.length)
			arr[k++] = right[j++];

		System.out.println(Arrays.toString(arr));
	}

	private static int mergeAndCount(int[] arr, int low, int mid, int high) {
		int[] left = Arrays.copyOfRange(arr, low, mid + 1);
		int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);

		int i = 0, j = 0, swaps = 0, k = low;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k] = right[j++];
				swaps += (mid + 1) - (low + i);
			}
		}

		// Fill from the rest of the left subarray
		while (i < left.length)
			arr[k++] = left[i++];

		// Fill from the rest of the right subarray
		while (j < right.length)
			arr[k++] = right[j++];

		return swaps;
	}

}
