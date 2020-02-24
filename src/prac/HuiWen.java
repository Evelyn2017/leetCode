package prac;

import java.util.Scanner;


/**
 * 字符串-->字符数组： toCharArray()
 * 字符数组-->字符串： valueOf()
 */

public class HuiWen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(isHui1(s));
        }
//        String s = " ";
//        System.out.println(isHui1(s));
//
//        int m = 1201;
//        String n = String.valueOf(m);


    }

    /**
     * 反转字符串
     * @param str
     * @return
     */
    public static boolean isHui(String str){
        if(str == null || str.equals(""))
            return false;
        boolean flag = true;
        String rev = new StringBuffer(str).reverse().toString();
        for(int i = 0; i < str.length(); i++)
            if(rev.charAt(i) != str.charAt(i))
                flag = false;

        return flag;

    }

    /**
     * 无需反转字符串
     * @param str
     * @return
     */

    public static boolean isHui1(String str){
        if(str == null || str.isEmpty())
            return false;
        boolean flag = true;
        for(int i = 0; i < str.length(); i++)
            if(str.charAt(i) != str.charAt(str.length() - i - 1))
                flag = false;
        return flag;
    }
}
