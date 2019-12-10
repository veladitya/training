package iamazon;

import java.util.Stack;

public class RectangularAreaHistogram {

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
        System.out.println("Maximum area is " + getMaxArea(hist)); 
	}
	
	static int getMaxArea(int[] a) {
		Stack<Integer> s = new Stack<>();
		
		int i=0;
		int n = a.length;
		int tp;
		int max_area= 0; 
		int temp_area;
		while(i < n) {
			
			if(s.isEmpty() || a[s.peek()] < a[i]) {
				s.push(i++);
			} else {
				tp = s.peek();
				s.pop();
				temp_area = a[tp] * (s.isEmpty()?i: i-s.peek()-1);
				
				if(temp_area > max_area)
					max_area = temp_area;
				
			}	
		}
		return max_area; 
	}
}
