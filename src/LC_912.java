public class LC_912 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        mergeSort(nums, result, 0, nums.length - 1);
        return nums;
    }
    private void mergeSort(int[] nums, int[] result, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, result, left, mid);
        mergeSort(nums, result, mid + 1, right);
        merge(nums, result, left, right, mid);
    }
    private void merge(int[] nums, int[] result, int left, int right, int mid) {
        int leftStart = left;
        int rightStart = mid + 1;
        int index = left;
        while (leftStart <= mid && rightStart <= right) {
            if (nums[leftStart] <= nums[rightStart]) {
                result[index++] = nums[leftStart++];
            } else {
                result[index++] = nums[rightStart++];
            }
        }
        while (leftStart <= mid) {
            result[index++] = nums[leftStart++];
        }
        while (rightStart <= right) {
            result[index++] = nums[rightStart++];
        }
        // 每次將 result[] 陣列的結果複製回原始陣列
        for (index = left; index <= right; index++) {
            nums[index] = result[index];
        }
    }
}
