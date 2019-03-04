package NO9;

/**
 * Determine whether a integer is palindrome
 */
public class PalindromeNumber {
    /**
     * no need to use string.
     * @param x: a number
     * @return true or fasle
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        int number = (int) Math.log10(x) + 1;
        int reverse = 0;
        for (int i = 0; i < number / 2; ++i) {
            reverse = 10 * reverse + x % 10;
            x /= 10;
        }
        return (x == reverse) || (x / 10 == reverse);
    }
}
