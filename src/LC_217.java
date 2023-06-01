// import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC_217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
    // 一行寫法，利用Arrays.stream()的方法，但是runtime/memory表現不好
    // Java 會在比較前進行型別轉換。但如果 distinct().count() 的結果超過了 int 的範圍，則可能會導致失真或溢位的問題
//    public boolean containsDuplicate(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return true;
//        }
//        return nums.length != Arrays.stream(nums).distinct().count();
//    }
}
