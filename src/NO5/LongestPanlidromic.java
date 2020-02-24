package NO5;

public class LongestPanlidromic {
    private int start;
    private int maxLen;

    /**
     * expand the substring from i both left and right
     * @param s String: abaccas
     * @return acca
     */
    public String getLongestsub(String s) {
        if (s.length() < 2)
            return s;

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i); //assume the result is odd
            expand(s, i, i + 1); //assume the result is even
        }

        return s.substring(start, start + maxLen);
    }

    public void expand(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            if (maxLen < k - j + 1) {
                maxLen = k - j + 1;
                start = j;
            }
            j--;
            k++;
        }
    }
}
