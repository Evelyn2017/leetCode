package NO000.TwoSum;

import java.util.Arrays;

/**
 * 遍历
 * 开始，结束位置
 */

public class TwoSum {

    public int[] Sum(int[]list, int target){
        int arr[] = {0, 0};
        for(int i = 0; i < list.length; i++){
            for(int j = i + 1; j < list.length; j++){
                if(list[i] + list[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] list = {1, 2, 4};
        int target = 6;
        TwoSum asum = new TwoSum();
        int[] result = asum.Sum(list, target);
        System.out.println(Arrays.toString(result));
    }
}


