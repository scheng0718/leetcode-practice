public class LC_80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 1;
        int count = 1;
        // fast pointer: 判斷與前一個元素是否重複，重複就更新 counter，不重複就重新設定 count = 1，
        // slow pointer: 用來記錄並更新陣列的位置，只要 count 在 2 以內的都賦值給slow
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[fast - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}

// TC = O(n)
// SC = O(1)
