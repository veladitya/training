package iamazon.logical.arrays;

import java.util.Arrays;
import java.util.Scanner;

class NextGreaterEvenNumber {
	public static void main(String[] args) {
		int[] digits = {9, 7, 1, 8, 7, 9, 7, 8, 3};
		int res = findNumber(digits, digits.length);
	}

	static int findNumber(int[] num, int n) {
		int i = n - 1;
		int part = 0;
		for (i = n - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				part = i;
				break;
			}
		}
		if (i == -1) {
			// System.out.println("exit desc");
			return -1;
		}
		for (i = n - 1; i > part; i--) {
			if (num[i] > num[part]) {
				swap(num, i, part);
				break;
			}
		}
		System.out.println(Arrays.toString(num));
		Arrays.sort(num, part + 1, n);
		System.out.println("After Sort == >"+Arrays.toString(num));
		if (num[n - 1] % 2 == 0) {
			return 1;
		} else {
			for (i = n - 1; i > part; i--) {
				if (num[i] % 2 == 0) {
					swap(num, i, n - 1);
					break;
				}
			}
			if (num[n - 1] % 2 == 0) {
				Arrays.sort(num, part + 1, n - 1);
				return 1;
				// }else if(num[n-1]%2!= 0 && num[part]%2 == 0 && num[n-1] > num[part]){
				// swap(num,part,n-1);
				// return 1;
				// }
			} else {
				return findNumber(num, n);
			}
		}
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}