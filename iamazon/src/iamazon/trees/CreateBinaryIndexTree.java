package iamazon.trees;

import java.util.Arrays;

//https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
public class CreateBinaryIndexTree {

	static int b[] = new int[1000]; 
	public static void main(String[] args) {
		System.out.println( (4 & -4) );
		int a[] = {0, 0, 0, 0, 0};
		createBinaryIndexTree(a, a.length);
		System.out.println(Arrays.toString(a));
		System.out.println("Binary Index Tree" +Arrays.toString(b));
		
		// Add 2 to all the 
        // element from [2,4] 
        int l = 2, r = 4, val = 2; 
        update(l, r, a.length, val); 
        System.out.println("Binary Index Tree" +Arrays.toString(b));
        
        int index = 4; 
        
        System.out.println("Element at index "+  
                                index + " is "+  
                                getSum(index)); 
        
        // Add 2 to all the  
        // element from [0,3] 
        l = 0; r = 3; val = 4; 
        update(l, r, a.length, val); 
  
        // Find the element 
        // at Index 3 
        index = 3; 
        System.out.println("Element at index "+  
                                index + " is "+  
                                getSum(index)); 
        
	}
	
	// SERVES THE PURPOSE OF getElement() 
    // Returns sum of arr[0..index]. This  
    // function assumes that the array is 
    // preprocessed and partial sums of 
    // array elements are stored in BITree[] 
    public static int getSum(int index) 
    { 
        int sum = 0; //Initialize result 
  
        // index in BITree[] is 1 more  
        // than the index in arr[] 
        index = index + 1; 
  
        // Traverse ancestors 
        // of BITree[index] 
        while (index > 0) 
        { 
  
            // Add current element  
            // of BITree to sum 
            sum += b[index]; 
  
            // Move index to parent  
            // node in getSum View 
            index -= index & (-index); 
        } 
  
        // Return the sum 
        return sum; 
    } 
  

	private static void update(int l, int r, int n, int val) {
		updateTree(l, val, n);
		updateTree(r+1, -val, n);
	}

	private static void createBinaryIndexTree(int[] a, int n) {
		
		for(int i=1; i<=n; i++)
			b[i]=0;
		
		for(int i=0; i<n; i++)
			updateTree(i, a[i], n);		
		
	}

	private static void updateTree(int i, int v, int n) {
		
		i = i+1;
		while(i<=n) {
			b[i] += v;			
			i = i+ (i & (-i));
			
		}
	}

}
