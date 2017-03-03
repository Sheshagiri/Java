import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sheshagiri
 */
public class PalindromeUtilTest {
 @Test
 public void testPalindromeStrings(){
	 Assert.assertTrue(PalindromeUtil.isPalindrome("abba"));
	 Assert.assertFalse(PalindromeUtil.isPalindrome("palindrome"));
	 Assert.assertTrue(PalindromeUtil.isPalindrome("Madam, I'm Adam."));
	 Assert.assertTrue(PalindromeUtil.isPalindrome("Mr. Owl ate my metal worm"));
	 Assert.assertTrue(PalindromeUtil.isPalindrome("Was it a cat I saw?"));
	 Assert.assertTrue(PalindromeUtil.isPalindrome("g"));
	 Assert.assertTrue(PalindromeUtil.isPalindrome(" "));
	 Assert.assertTrue(PalindromeUtil.isPalindrome("&&&&"));
	 Assert.assertFalse(PalindromeUtil.isPalindrome("&&ab123cd&&"));
	 Assert.assertTrue(PalindromeUtil.isPalindrome("&&123321&&"));
 }
}
