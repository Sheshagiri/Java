/**
 * Checks if a string is a palindrome.
 *
 * @author Sheshagiri
 * Palindrome is a word, phrase or sentence that reads the same backward or
 * forward. For example, the following string is a palindrome: "Madam, I'm Adam."
 */
public class PalindromeUtil {
	/**
	 * Checks whether passed String is a palindrome or not.
	 *
	 * Requirements:
	 * - Limit the amount of additional consumed memory to O(1).
	 * - Limit complexity to O(n).
	 *
	 * @return true if passed string is palindrome, false - otherwise
	 */
	public static boolean isPalindrome(String str) {
		char[] cArray = str.replaceAll("[\\W]", "").toLowerCase().toCharArray();
		int start = 0;
		int end = cArray.length-1;
		while(end > start){
			if(cArray[start]!=cArray[end]){
				return false;
			}
			++start;
			--end;
		}
		return true;
	}
}

