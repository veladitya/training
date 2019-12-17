package iamazon.arrays;

public class MaxSumNotAdjacent {

	public static void main(String[] args) {
		System.out.println(maxSum(new int[] {1, 20, 40, 3}));
	}

	public static int maxSum(int[] arr) {
		int include= arr[0];
		int exclude = 0;
		int tempExclude;
		for(int i=1;i<arr.length; i++) {
			System.out.println("===============>");
			tempExclude = include > exclude? include: exclude;
			System.out.println(tempExclude);
			include = exclude + arr[i];			
			System.out.println(include);
			exclude = tempExclude;
			System.out.println(exclude);
		}
		
		System.out.println("include "+ include);
		
		/* return max of incl and excl */
        return ((include > exclude) ? include : exclude); 
	}
}
