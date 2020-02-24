package NO4;

public class MedianNum {
    public static double getMedianNum(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length)
//            return getMedianNum(nums2, nums1);

        int len1 = nums1.length;
        int len2 = nums2.length;

        int start = 0;
        int end = len1;

        while (start <= end) {
            int partion1 = (start + end) / 2;
            int partion2 = (len1 + len2 + 1) / 2 - partion1;

            int maxLeft1 = (partion1 == 0) ? Integer.MIN_VALUE : nums1[partion1 - 1];
            int minRight1 = (partion1 == len1) ? Integer.MAX_VALUE : nums1[partion1];

            int maxleft2 = (partion2 == 0) ? Integer.MIN_VALUE : nums2[partion2 - 1];
            int minRight2 = (partion2 == len2) ? Integer.MAX_VALUE : nums2[partion2];

            if (maxLeft1 <= minRight2 && maxleft2 <= minRight1) {
                if ((len1 + len2) % 2 == 0) {
                    return ((double) (Math.max(maxLeft1, maxleft2) + Math.min(minRight1, minRight2)) / 2);
                } else
                    return Math.max(maxleft2, maxLeft1);
            } else if (maxLeft1 > minRight2) {
                end = partion1 - 1;

            } else {
                start = partion1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,6};
        int[] num2  = {1,2,5,24};

        System.out.println(getMedianNum(num1, num2));

    }
}
