import java.util.ArrayList;
import java.util.List;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
  // Method 1: use ArrayList
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    List<Integer> list = new ArrayList<>();
    while (head != null) {
        list.add(head.val);
        head = head.next;
    }
    int left = 0;
    int right = list.size() - 1;
    while (left <= right) {
        if (list.get(left) != list.get(right)) return false;
        left++;
        right--;
    }
    return true;    
  }
  // Methods 2: O(1) Space
  public boolean isPalindromeOptimized(ListNode head) {
    if (head == null || head.next == null) return true;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode current = slow;
    ListNode prev = null;
    while (current != null) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    ListNode head1 = head;
    ListNode head2 = prev;
    while (head1 != null && head2 != null) {
        if (head1.val != head2.val) return false;
        head1 = head1.next;
        head2 = head2.next;
    }           
    return true;
  }
}