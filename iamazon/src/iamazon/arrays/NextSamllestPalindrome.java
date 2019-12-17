package iamazon.arrays;

import java.util.Arrays;

public class NextSamllestPalindrome {

	public static void main(String[] args) {
		int num[] = { 9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2 };
		generateNextPalindrome(num, num.length);
		System.out.println(Arrays.toString(num));
	}

	static void generateNextPalindrome(int[] a, int n) {
		int m = n / 2;
		int i = m - 1;
		int j = n % 2 == 0 ? m : m + 1;
		
		while(i>=0 && a[i] == a[j]) {
			i--;
			j++;
		}
		boolean leftSmaller = false;
		if(i<0 || a[i] < a[j]) {
			leftSmaller = true;
		}
		
		while(i>=0) {
			a[j++]=a[i--];
		}
		
		//middle element needed to be incremented
		if(leftSmaller) {
			int carryOver = 1;
			a[m]+=carryOver;
			carryOver = carryOver/10;
			a[m] =a[m]%10;
			
			//reset the i and j and include carryover
			
			i=m-1;
			j=n%2 ==0?m:m+1;
			
			while(i<=0 && j <= n) {
				a[i] = a[i]+carryOver;
				carryOver= a[i] / 10;
				a[i] = a[i]% 10;
				
				a[j] = a[i];
				i--;
				i++;
			}
		}
		
		
	}

}
