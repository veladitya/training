package iamazon;

import java.util.Arrays;

public class ArrayQuickSort {

	public static void main(String[] args){
		int[] a = {12, 5, 6, 3, 9, 23};
		performQuickSort(a, 0, 5);
		System.out.println(Arrays.toString(a));
	}

	static void performQuickSort(int[] a, int l, int r) {
		if (l < r)  { 
			// find pivot
			int pivot = findPivot(a, l, r);

			// perform quick sort between l to pivot-1
			performQuickSort(a, l, pivot - 1);
			// perform quick sort between pivot+1 to h
			performQuickSort(a, pivot + 1, r);
        }
		
	}

	static int findPivot(int[] a, int l, int r) {

		// takes last element as pivot
		int x = a[r];
		int i = l;

		for (int j = l; j <= r-1; j++) {

			if (a[j] <= x) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}

		int temp = a[i];
		a[i] = a[r];
		a[r] = temp;

		return i;
	}
	
	
}