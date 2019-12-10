package iamazon;

import java.util.Arrays;

public class RArrayRotation {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int byD = 8;
		int sz = arr.length;
		rotateArray(arr, byD, sz);
	}

	private static void rotateArray(int[] arr, int byD, int sz) {
		int[] tempArr = new int[byD];
		int temp =0 ;
		for (int i = 0; i < arr.length; i++) {
			if (i < byD) {
				tempArr[i] = arr[i];
			}  else {
				arr[i - byD] = arr[i];
			}
			
			if (byD >= sz - i) {
				//arr[i - byD] = tempArr[sz-i-1];
				arr[i] = tempArr[temp];
				temp++;
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
