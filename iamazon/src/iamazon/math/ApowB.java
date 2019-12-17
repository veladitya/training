package iamazon.math;

public class ApowB {

	public static void main(String args[]) {
		
		System.out.println(powerFuc(2, 8));
		
	}
	
	static Float powerFuc(float a, int b) {
		if(b == 0) {
			return 1.0f;
		}
		return a * powerFuc(a, b-1);
	}
}
