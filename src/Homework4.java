public class Homework4 {
	
	public static void main(String[] args) {
	}
	
	public static boolean_int Horspool(String text, String pattern) {
		return null;
	}
	
	public static boolean_int bruteforceforStringMatching(String text, String pattern) {
		boolean_int bi = new boolean_int();
		
		if (text == null || text.isEmpty() || pattern == null || pattern.isEmpty()) {
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
	
	@Override
	public String toString() {
		return "boolean_int [bool_tag=" + bool_tag + ", count=" + count + "]";
	}
}
