package NO26;

public class RemoveDuplicates {
    /**
     *
     * @param nums [1,1,2]
     * @return 2
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;
        else if (nums.length == 0)
            return 0;

        else {
            int len = 1;
            for (int j = 1; j < nums.length; j++) {
                if(nums[j] != nums[j-1]){
                    nums[len] = nums[j];
                    len ++;
                }
            }
            return len;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,4,4,5,5,5,5,6,6,6,7};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i< len; i++)
            System.out.print(nums[i]);
    }
}
