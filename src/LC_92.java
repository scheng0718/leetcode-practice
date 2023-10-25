class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || left == right) return head;
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    dummy.next = head;
    for (int i = 0; i < left - 1; i++) {
        prev = prev.next;
    }
    ListNode current = prev.next;
    ListNode next = null;
    for (int i = left; i < right; i++) {
        next = current.next;
        current.next = next.next;
        next.next = prev.next;
        prev.next = next;
    }
    return dummy.next;
  }
}