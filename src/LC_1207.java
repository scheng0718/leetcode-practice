import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // map.forEach((key, value) -> System.out.println("key is: " + key + "value is: " + value));
        // method 1: iterate over the hashset and check if duplicate
        Set<Integer> res = new HashSet<>();
        for (Integer value: map.values()) {
            if (res.contains(value)) {
                return false;
            }
            res.add(value);
        }
        return true;
        // method 2: 將map.values()當參數傳進hashset，判斷map和set的size
        // Set<Integer> res = new HashSet<>(map.values());
        // return map.size() == res.size();
    }
}
