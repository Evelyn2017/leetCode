package NO9;

/**
 * Determine whether a integer is palindrome
 */
public class PalindromeNumber {
    /**
     * no need to use string.
     * @param x: a number
     * @return true or false
     */
    public boolean isPalindrome(int x) {
        if(x <= 0 || x  % 10 == 0)          // Negative numbers or a number like 10 can not be a palindrome
            return x == 0;

        int rev = 0;

        while(x > rev)
        {
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }

        return x == rev || x == rev / 10;	// Number of digits in n is Even or Odd
    }
}
