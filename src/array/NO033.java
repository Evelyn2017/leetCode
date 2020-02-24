package array;

public class NO033 {
    /**
     *
     * @param nums [4,5,6,7,0,1,2]
     * @param target 5
     * @return 2
     */
    private static int search(int[] nums, int target) {
        if (nums.length ==0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        int mid;

        //find the smallest element
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        int rotate = low;

        //define which part the target is in
        low = 0;
        high = nums.length - 1;
        if(target > nums[rotate] && target<nums[high])
            low = rotate;
        else
            high = rotate;

        //binary search (not in the whole array)
        while(low < high) {
            mid = (low + high) / 2;
            if(target == nums[mid])
                return mid;
            else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        int t =1 ;
        System.out.println(search(a, t));
    }
}
