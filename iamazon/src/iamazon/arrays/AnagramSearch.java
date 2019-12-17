package iamazon.arrays;

public class AnagramSearch {

	public static void main(String[] args) {
		String txt = "bcadeh"; 
        String pat = "hea"; 
        System.out.println(search(pat, txt));
	}

	private static int search(String pat, String txt) {
		
		char[] s = pat.toCharArray();
		char[] t = txt.toCharArray();
		int i=0, n=t.length, j=s.length;
		int c = 0; 
		boolean isLstElement= false;
		int totalCount =0;
		while(i< n) {
			
			if(isPresent(s, t[i]))
				c++; 
			else {
				c=0;
				s = pat.toCharArray();
			}
				
			if(c == j) {
				//System.out.println("Found at index "+ (i-j +1));
				totalCount++;
				c=0;	
				s = pat.toCharArray();
				i = i-j +1;
			}
			i++;
				
		}	
		
		return totalCount;
	}
	
	static boolean isPresent(char[] s, char t) {
		for(int k=0; k<s.length; k++) {
			if(t == s[k]) {
				s[k] ='#';
				return true;
			}
				
		}
		
		return false;
	}

}
