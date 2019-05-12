package array;

public class NO034 {
    /**
     *
     * @param nums [5,7,7,8,8,10]
     * @param target 8
     * @return [3,4]
     */
    private static int[] findRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0)
            return res;
        int left = binary(nums, target - 0.5);
        int right = binary(nums, target + 0.5);
        if (left == right)
            return res;
        res[0] = left;
        res[1] = right - 1;
        return res;
    }

    private static int binary(int[] nums, double target) {
        int start = 0;
        int end = nums.length - 1;
        int mid ;
        while(start <= end) {
            mid = (start + end) / 2;
            if(target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,5,5,5,5,6,7,8};
        int target = 5;
        int[] res = findRange(nums, target);
        for (int a:res
             ) {
            System.out.print(a);

        }
    }
}
