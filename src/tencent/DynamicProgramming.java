package tencent;

/**
 * @author evelyn
 * @description TODO
 * @date 2019-09-01 21:35
 **/
public class DynamicProgramming {
    public static void main(String[] args) {
        System.out.println(StepClimbing.getTotal(10));
    }
}

class StepClimbing {
    static int getTotal (int maxStep) {
        if (maxStep < 1)
            return 0;
        if (maxStep == 1)
            return 1;
        if (maxStep == 2)
            return 2;

        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= maxStep; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}


class MaxSubString {
    public static void main(String[] args) {
        String ff = "abc";
        String se = new String("abc");  
        String th = "a" + "b" + "c";
        System.out.println(ff == se);
        System.out.println(ff == th );
    }
}
