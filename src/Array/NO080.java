package Array;

public class NO080 {
    //允许最多有一个重复值，可以扩展到允许最多有n个重复值

    /**
     * @param nums  [1,1,2,2,3]
     * @return 3
     */
    private static int removeDuplicates1_1(int[] nums) {
        int t = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[t - 1])
                nums[t++] = nums[i];
        }
        return t;
    }

    public static int removeDuplicates1_2(int[] nums) {
        int t = 1;
        int i = 0;
        for(int n : nums) {
            if(i < 1 || n > nums[i - 1])
                nums[i++] = n;
        }

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4};
        int len = removeDuplicates1_1(arr);
        System.out.println();
    }
}
