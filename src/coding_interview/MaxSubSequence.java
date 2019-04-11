package coding_interview;

public class MaxSubSequence {
    private static int getMax(int[] nums) {
        if (nums.length < 1)
            return 0;

        for (int i = 0; i < nums.length; i++) {
            int result = 0;
            for (int j =i;i<nums.length;j++){
                result+=nums[j];
            }
        }
        return 0;
    }
}
