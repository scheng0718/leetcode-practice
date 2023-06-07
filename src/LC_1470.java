/**
 *  TC = O(n)
 *  SC = O(1)
 */
public class LC_1470 {
    public int[] shuffle(int[] nums, int n) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length];

        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return result;
    }
}
// Follow-up: complete it using in-place

//    public int[] shuffle(int[] nums, int n) {
//
//        int len = nums.length;
//        [1, 2, 3, 4] => 1 和 3 打包 , 10 這個數字要比陣列中的元素都還要大，
//        ex: 3 * 10 + 1 = 31 => 31 % 10=> 1, 31/10 = 3
//
//        所以這裡因為題目限制 1 <= nums[i] <= 10^3 所以選擇用 2^10 = 1024 方便進行 bit operation
//        for(int i = n; i < len; i++) {
//            nums[i] = (nums[i] * 1024) + nums[i - n];
//        }
//
//        int index = 0;
//        for(int i = n; i < len; i++, index += 2) {
//            nums[index] = nums[i] % 1024;
//            nums[index + 1] = nums[i] / 1024;
//        }
//
//        return nums;
//    }
// 對照上面的運算，可以轉換成 bit operation
// public int[] shuffle(int[] nums, int n) {
//
//    int len = nums.length;
//
//    for(int i = n; i < len; i++) {
//                          左移 10 位 加上 或運算
//        nums[i] = (nums[i] << 10) | nums[i - n];
//    }
//
//    int index = 0;
//    for(int i = n; i < len; i++, index += 2) {
//        nums[index] = nums[i] & 1023;
//        nums[index + 1] = nums[i] >>> 10;
//    }
//
//    return nums;
//}