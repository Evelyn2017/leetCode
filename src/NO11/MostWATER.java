package NO11;

public class MostWATER {
    public int ContainerMostWater(int[] height) {
        int start = 0, end = height.length;
        int maxArea = 0;

        while (start < end) {
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));

            if (height[start] < height[end])
                start++;
            else
                end--;
        }

        return maxArea;
    }
}
