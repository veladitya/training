package iamazon.logical.arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = arr.length;
		System.out.print(maxWater(arr, n));
	}

	public static int maxWater(int[] a, int n) {
		int water = 0;
		int tmp = 0;
		int prev = a[0];
		int prevIndex = 0;
		// iterate array and find the max element
		// if the previous element is less that current element
		// then update the maxwater saved and take the same to temp
		for (int i = 1; i < n; i++) {
			if (a[i] > prev) {
				prev = a[i];
				prevIndex = i;
				tmp = 0;
			} else {
				water += a[prevIndex] - a[i];
				tmp += a[prevIndex] - a[i];
			}
		}

		// if the previous index is not last element
		// then delete temporary addition of water from actual water(excess water)
		// and iterate from last index by setting prev as last element
		if (prevIndex <= n - 1) {
			water -= tmp;
			prev = a[n - 1];
			for (int i = n - 1; i >= prevIndex; i--) {
				if (a[i] >= prev) {
					prev = a[i];
				} else {
					water += prev - a[i];
				}
			}
		}
		return water;
	}

}
