package NO7;

public class ReverseInt {
    public static int reverseInteger(int x) {
        int result = 0;
        //int newRes;

        while (x != 0) {
            int tail = x % 10;
            int newRes = result * 10 + tail;

            if ((newRes - tail) / 10 != result)
                return Integer.MIN_VALUE;

            result = newRes;
            x /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        int x = -123;

        System.out.println(reverseInteger(x));
    }
}
