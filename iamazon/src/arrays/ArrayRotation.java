package arrays;

public class ArrayRotation {

	public static void main(String[] args) {
		// Let us search 3 in below array 
	       int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; 
	       int n = arr1.length; 
	       int key = 3; 
	       System.out.println("Index of the element is : "
	                      + pivotedBinarySearch(arr1, n, key)); 
	}

	static int pivotedBinarySearch(int arr[], int n, int key) 
    { 
       int pivot = findPivot(arr, 0, n-1); 
        
       // If we didn't find a pivot, then  
       // array is not rotated at all 
       if (pivot == -1) 
           return binarySearch(arr, 0, n-1, key); 
        
       // If we found a pivot, then first  
       // compare with pivot and then 
       // search in two subarrays around pivot 
       if (arr[pivot] == key) 
           return pivot; 
       if (arr[0] <= key) 
           return binarySearch(arr, 0, pivot-1, key); 
       return binarySearch(arr, pivot+1, n-1, key); 
    } 
	
	static int findPivot(int arr[], int low, int high) 
    { 
		System.out.println("low ==>>"+ low);
		System.out.println("high ==>>"+ high);
		
       // base cases 
       if (high < low)   
            return -1; 
       if (high == low)  
            return low; 
         
       /* low + (high - low)/2; */
       int mid = (low + high)/2;    
       System.out.println("mid ==>>"+ mid);
	   System.out.println("arr[mid] ==>>"+ arr[mid]);
	   System.out.println("arr[mid + 1] ==>>"+arr[mid + 1]);
	   System.out.println("arr[mid - 1] ==>>"+arr[mid - 1]);
       if (mid < high && arr[mid] > arr[mid + 1]) 
           return mid; 
       if (mid > low && arr[mid] < arr[mid - 1]) 
           return (mid-1); 
       System.out.println("arr[low] ==>>"+arr[low]);
       if (arr[low] >= arr[mid]) 
           return findPivot(arr, low, mid-1); 
       return findPivot(arr, mid + 1, high); 
    }
	
	/* Standard Binary Search function */
    static int binarySearch(int arr[], int low, int high, int key) 
    { 
       if (high < low) 
           return -1; 
         
       /* low + (high - low)/2; */       
       int mid = (low + high)/2;   
       if (key == arr[mid]) 
           return mid; 
       if (key > arr[mid]) 
           return binarySearch(arr, (mid + 1), high, key); 
       return binarySearch(arr, low, (mid -1), key); 
    } 
	
	private static void rotation1() {
		ArrayRotation rotate = new ArrayRotation(); 
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 }; 
        rotate.leftRotate(arr, 2, 8); 
        rotate.printArray(arr, 8);
	}

	/*Function to left rotate arr[] of siz n by d*/
    void leftRotate(int arr[], int d, int n) 
    { 
        int i, j, k, temp; 
        int g_c_d = gcd(d, n); 
        System.out.println("g_c_d ==>>" +g_c_d);
        for (i = 0; i < g_c_d; i++) { 
            /* move i-th values of blocks */
            temp = arr[i]; 
            j = i; 
            while (true) { 
                k = j + d; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break; 
                arr[j] = arr[k]; 
                j = k; 
                printArray(arr, n);
            } 
            arr[j] = temp; 
        } 
    } 
  
    /*UTILITY FUNCTIONS*/
  
    /* function to print an array */
    void printArray(int arr[], int size) 
    { 
        int i; 
        for (i = 0; i < size; i++) 
            System.out.print(arr[i] + " "); 
        System.out.print("\n"); 
    } 
  
    /*Fuction to get gcd of a and b*/
    int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    } 
	
}
