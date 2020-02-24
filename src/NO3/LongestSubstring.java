package NO3;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    /**
     * slide window technique:use two pointers.
     * @param s abcaabcd
     * @return 4
     */
    public int getLongestSubstr(String s) {
        if (s==null || s.length() == 0)
            return 0;

        int left = 0;
        int right = 0;
        int maxsub = 0;

        Set<Character> set = new HashSet<>();

        while (right < s.length()) { // ensure the window is valid
            if (set.add(s.charAt(right))) {
                right++;
                maxsub = Math.max(maxsub, right-left);
            }
            else{
                set.remove(s.charAt(left));  //a repeated character appears then remove it
                left++;
            }
        }
        return maxsub;
    }
}
