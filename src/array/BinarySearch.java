package array;

public class BinarySearch {
    public int binary(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start < end) {
            mid = start + (start + end) / 2;
            if(target == nums[mid])
                return mid;
            else if (target < nums[mid])
                end = mid - 1;
            else
                end = mid + 1;
        }
        return -1;
    }

    public int binary(int[] nums, int target, int start, int end) {
        int mid = start + (start + end) / 2;
        if(target == nums[mid])
            return mid;
        if (start > end)
            return -1;
        else if(target < nums[mid])
            return binary(nums, target, start, mid - 1);
        else
            return binary(nums, target, mid + 1, end);
    }
}
