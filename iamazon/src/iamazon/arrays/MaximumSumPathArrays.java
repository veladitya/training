package iamazon.arrays;

public class MaximumSumPathArrays {

	public static void main(String[] args) {
		int ar1[] = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int ar2[] = { 1, 5, 7, 8, 10, 15, 16, 19 };
		int m = ar1.length;
		int n = ar2.length;
		System.out.println("Maximum sum path is :" + maxPathSum(ar1, ar2, m, n));
	}

	static int getMax(int s1, int s2) {
		return (s1 > s2) ? s1 : s2;
	}

	private static int maxPathSum(int[] a, int[] b, int m, int n) {
		int result = 0;
		int i = 0, j = 0, sum1 = 0, sum2 = 0;

		while (i < m && j < n) {

			if (a[i] < b[j])
				sum1 += a[i++];

			else if (a[i] > b[j])
				sum2 += b[j++];
			
			else {
				result +=  getMax(sum1, sum2);
				sum1 = 0; 
                sum2 = 0; 
				if(i < m && j < n &&  a[i] == b[j]) {
					result = result + a[i];
					i++;
					j++;
				}
			}
		}
		
		while(i < m) {
			sum1  += a[i++];
		}
		
		while(j < n) {
			sum2 +=  a[j++];
		}
		
		return result+= getMax(sum1, sum2);
	}
}
