public class LC_11 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (start < end) {
            int h = Math.min(height[start], height[end]);
            int w = end - start;
            int currArea = h * w;
            maxArea = Math.max(currArea, maxArea);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
