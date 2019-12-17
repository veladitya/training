package iamazon.arrays;

/**
 * if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6”.
 * @param args
 */
public class StringEncode {

	public static void main(String[] args) {
		System.out.println(compress("wwwwaaadexxxxxx"));
	}
	
	static String compress(String s) {
		String compressedStr = "";
		char[] allChars = s.toCharArray(); 
		char temp = 0; 
		int count = 0;
		for(int i=1; i<allChars.length; i++) {
			if(temp == 0) {
				temp = allChars[i];
			}
			if(temp == allChars[i]) {
				count++; 
			}else {
				compressedStr = compressedStr+temp+(count+1);
				count = 0;
			}
			temp = allChars[i];
			
		}
		return compressedStr;
	}
	
}
