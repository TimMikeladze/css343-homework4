import java.util.Arrays;

public class Homework4 {
	
	public static void main(String[] args) {
		
	}
	
	public static boolean_int Horspool(String text, String pattern) {
		boolean_int bi = new boolean_int();
		
		if (pattern == null || text == null || pattern.isEmpty() || text.isEmpty() || pattern.length() > text.length()) {
			return bi;
		}
		
		char[] patternChars = pattern.toCharArray();
		char[] textChars = text.toCharArray();
		
		int currentPosition = 0;
		int lastPosition = patternChars.length - 1;
		
		int[] shift = new int[256];
		Arrays.fill(shift, patternChars.length);
		
		for (int i = 0; i < lastPosition; i++) {
			shift[patternChars[i]] = lastPosition - i;
		}
		
		while (currentPosition <= textChars.length - patternChars.length) {
			bi.count++;
			for (int i = lastPosition; patternChars[i] == textChars[i + currentPosition]; i--) {
				bi.count++;
				if (i == 0) {
					bi.count--;
					bi.bool_tag = true;
					return bi;
				}
			}
			currentPosition += shift[textChars[currentPosition + lastPosition]];
		}
		return bi;
	}
	
	public static boolean_int bruteforceforStringMatching(String text, String pattern) {
		boolean_int bi = new boolean_int();
		
		if (pattern == null || text == null || pattern.isEmpty() || text.isEmpty() || pattern.length() > text.length()) {
			return bi;
		}
		
		int textLength = text.length();
		int patternLength = pattern.length();
		
		for (int i = 0; i <= textLength - patternLength; i++) {
			int j = 0;
			bi.count++;
			while (j < patternLength && text.charAt(i + j) == pattern.charAt(j)) {
				j++;
				bi.count++;
			}
			if (j == patternLength) {
				bi.count--;
				bi.bool_tag = true;
				break;
			}
		}
		
		return bi;
	}
}

class boolean_int {
	
	Boolean bool_tag;//if there is a matching, bool_tag = true. Otherwise bool_tag = false;
	int count;//record the total number of comparisons after the algorithm ends;
	
	boolean_int() {
		bool_tag = false;
		count = 0;
	}
}
