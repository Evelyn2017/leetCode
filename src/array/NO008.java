package array;

//String to Integer

public class NO008 {
    /**
     * @param str "  -42"
     * @return 42
     */
    private static int myAoti(String str) {
        int index = 0;
        int sign = 1;
        int total = 0;

        if (str.length() == 0)
            return 0;

        while (index < str.length() && str.charAt(index) == ' ')
            index++;

        if (index < str.length() && ((str.charAt(index) == '+') || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9)
                break;
            if (Integer.MAX_VALUE / 10 <= total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
        String a = "  -42";
        System.out.println(myAoti(a));
    }
}