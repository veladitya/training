package iamazon;
//find max number that can be formed from swap operations 

public class MaxNumberBySwapOprLimt {
	public static void main(String[] args) {
		int a[] = { 9, 0, 8, 3 };
		MaxNumberBySwapOprLimt t = new MaxNumberBySwapOprLimt();
		int b[] = t.swapWithLimit(a, 2);
		for (int i : b) {
			System.out.print(i + ", ");
		}
	}

	static int getMaxIndex(int[] a) {
		int tmp = 0;
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (tmp < a[i]) {
				index = i;
				tmp = a[i];
			}
		}
		return index;
	}

	// {3,8,9}, 1
	public int[] swapWithLimit(int[] array, int limit) {
		int limitLeft = limit;
		for (int j = 0; (j < array.length) && (limitLeft > 0); j++) {
			int maxIndx = j;

			for (int i = j + 1; i < array.length; i++) {

				if ((array[maxIndx] < array[i])) {
					maxIndx = i;
				}
			}

			if (maxIndx != j) {
				int temp = array[j];
				array[j] = array[maxIndx];
				array[maxIndx] = temp;

				limitLeft--;

			}
		}
		return array;

	}
}