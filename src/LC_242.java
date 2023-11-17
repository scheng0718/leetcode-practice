public class LC_242 {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] counter = new int[26];
    for (char element : s.toCharArray()) {
      counter[element - 'a']++;
    }
    for (char element : t.toCharArray()) {
      counter[element - 'a']--;
    }
    for (int count : counter) {
      if (count != 0) return false;
    }    
    return true;
  }
}