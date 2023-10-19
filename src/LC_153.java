class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
          int middle = left + (right - left) / 2;
          if (nums[middle] > nums[right]) {
            left = middle + 1;
          } else {
            right = middle;
          }
        }
        return nums[left];
    }
}