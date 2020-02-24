package NO6;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    /**
     * @param s      abcdefghin
     * @param numRow 3
     * @return aeibdfhncg
     * a   e   i
     * b d f h n
     * c   g
     */
    private static String conversion(String s, int numRow) {
        if (s.length() == 1)
            return s;

        int currRow = 0;
        boolean goingDown = false;

        List<StringBuilder> rows = new ArrayList<>(); //store row
        for (int i = 0; i < Math.min(numRow, s.length()); i++)
            rows.add(new StringBuilder());

        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c); //遍历字符串，把当前字符分配给第i个row
            if (currRow == 0 || currRow == numRow - 1) //判断是否转换方向
                goingDown = !goingDown;
            currRow += goingDown ? 1 : -1; //向下走currRow + 1； 向上currRow - 1
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows)
            result.append(row);

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefghin";
        System.out.println(conversion(s, 3));
    }
}
