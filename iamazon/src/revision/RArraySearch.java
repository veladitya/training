package revision;

public class RArraySearch {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int key = 2;
		int high = arr.length;
		int low = 0;
		int index = performSearch(arr, key, 0, high);
		System.out.println(index);
	}

	public static int performSearch(int[] arr, int key, int startIndex, int size) {
		int pivotIndex = findPivot(arr, startIndex, size);
		
		if(pivotIndex == -1) {
			return binarySearch(arr, 0, size, key);
		}
		
		if(arr[pivotIndex] == key) {
			return pivotIndex;
		}
		
		if(arr[0] < key) {
			return binarySearch(arr, 0, pivotIndex-1, key);
		}
		
		
		return binarySearch(arr, pivotIndex+1, size, key);	
	}

	private static int binarySearch(int[] arr, int startIndex, int endIndex, int key) {
		if(endIndex < startIndex)
			return -1;
		
		int mid = (startIndex + endIndex) / 2;
		
		if(arr[mid] == key) {
			return mid;
		}
		
		if(key > arr[mid])
			return binarySearch(arr, mid+1, endIndex, key);
		return binarySearch(arr, startIndex, mid-1, key);
	}

	private static int findPivot(int[] arr, int low, int high) {
		if(high < low) 
			return -1;
		if (high == low)
			return 0;
		
		int mid = (low + high) / 2;

		int midVal = arr[mid];
		int preMidVal = arr[mid - 1];
		int nextMidVal = arr[mid + 1];
		int lowVal = arr[low];
		
		System.out.println("-----------------------------------");
		System.out.println("Low Value: ["+lowVal+"]"+"High Value: []"+"low & high Index: ["+low+","+high+"]");
		System.out.println("Pre Mid Value: ["+preMidVal+"]"+"Mid Value: ["+midVal+"]"+"Next Mid Value: ["+nextMidVal+"]");
		System.out.println("Pre Mid Index: ["+(mid-1)+"]"+"Mid Index: ["+mid+"]"+"Next Mid Value: ["+(mid+1)+"]");
		System.out.println("-----------------------------------");
		
		if (mid < high && midVal > nextMidVal)
			return mid;
		if (mid < low &&midVal < preMidVal)
			return mid - 1;

		if (lowVal > midVal)
			return findPivot(arr, low, mid - 1);

		return findPivot(arr, mid + 1, high);
	}
}
