package revision;

public class ArraySearchR1 {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int key = 2;
		int high = arr.length;
		int low = 0;
		int index = performSearch(arr, key, 0, high);
		System.out.println(index);
	}
	
	private static int performSearch(int[] arr, int key, int l, int h) {
		
		int pivotIndex = findPivot(arr, l, h-1);
		
		if(pivotIndex == -1)
			return performBinarySearch(arr, 0, h, key);
		
		if(arr[pivotIndex] == key)
			return pivotIndex;
		
		if(arr[0] < key)
			return performBinarySearch(arr, 0, pivotIndex-1, key);
		
		return performBinarySearch(arr, pivotIndex+1, h, key);
	}

	private static int performBinarySearch(int[] arr, int l, int h, int key) {
		
		if(h < l)
			return -1;
		
		
		int m = (l + h) / 2;
		
		if(arr[m] == key) {
			return m;
		}
		if(key  <  arr[m] )
			return performBinarySearch(arr, l, m-1, key);
		
		return performBinarySearch(arr, m + 1, h, key);
	}

	public static int findPivot(int[] arr, int low, int high) {
		
		if(high < low)
			return -1; 
		
		if(high == low)
			return low;
		
		int mid = (high + low) / 2;
		//values 
		int midVal = arr[mid];
		int nextMidVal = arr[mid+1];
		int preMidVal = arr[mid -1];
		int lowVal = arr[low];
		System.out.println("-----------------------------------");
		System.out.println("Low Value: ["+lowVal+"]"+"High Value: []"+"low & high Index: ["+low+","+high+"]");
		System.out.println("Pre Mid Value: ["+preMidVal+"]"+"Mid Value: ["+midVal+"]"+"Next Mid Value: ["+nextMidVal+"]");
		System.out.println("Pre Mid Index: ["+(mid-1)+"]"+"Mid Index: ["+mid+"]"+"Next Mid Value: ["+(mid+1)+"]");
		System.out.println("-----------------------------------");
		
		if(mid < high && midVal > nextMidVal)
			return mid;
		if(mid > low && midVal < preMidVal)
			return mid-1;
		
		if(lowVal > midVal)
			findPivot(arr, lowVal, mid-1);
		
		
		return findPivot(arr, mid+1, high);
	}
}
