import java.util.Arrays;

public class Homework4 {
	
	public static void main(String[] args) {
		System.out.println();
		computeLevenshteinDistance("book", "dog");
	}
	
	private static int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
	
	public static int computeLevenshteinDistance(String str1, String str2) {
		char[] a = str1.toCharArray();
		char[] b = new char[str2.length()];
		
		int[][] distance = new int[str1.length() + 1][str2.length() + 1];
		
		for (int i = 0; i <= str1.length(); i++) {
			distance[i][0] = i;
		}
		for (int j = 1; j <= str2.length(); j++) {
			distance[0][j] = j;
		}
		
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				int deletion = distance[i - 1][j] + 1;
				int insertion = distance[i][j - 1] + 1;
				int sub = distance[i - 1][j - 1] + ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1);
				
				distance[i][j] = minimum(deletion, insertion, sub);
				if (distance[i][j] == deletion) {
					b[j - 1] = '\\';
				} else if (distance[i][j] == insertion) {
					b[j - 1] = str2.charAt(j - 1);
				} else if (distance[i][j] == sub) {
					b[j - 1] = str2.charAt(j - 1);
				}
			}
		}
		
		System.out.println(str1);
		System.out.println(new String(b));
		
		for (int row[] : distance) {
			for (int i : row) {
				System.out.print(i);
				System.out.print("\t");
			}
			System.out.println();
		}
		
		return distance[str1.length()][str2.length()];
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
