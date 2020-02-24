package NO16;

import java.util.Arrays;

public class ThreeSumCloest {
    /**
     *
     * @param nums [-1,2,1,4]
     * @param target 1
     * @return 2:(-1+2+1=2)
     */
    private static int threeSumCloset(int[] nums, int target){
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);

        for (int i=0; i< nums.length - 2; i++){
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                else if(sum > target)
                    high--;
                else
                    low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-1,2,1,4};
        int target = 1;
        System.out.println(threeSumCloset(a, target));
    }
}
