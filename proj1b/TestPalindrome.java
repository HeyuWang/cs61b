import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        String word1 = "a";
        boolean testResult = palindrome.isPalindrome(word1);
        assertTrue(testResult);

        String word2 = "ab";
        assertFalse(palindrome.isPalindrome(word2));

        String word3 = "aba";
        assertTrue(palindrome.isPalindrome(word3));
    }
    @Test
    public void testIsPalindromeOffByOne(){
        OffByOne cmp = new OffByOne();

        assertTrue(palindrome.isPalindrome("abb",cmp));

    }
}