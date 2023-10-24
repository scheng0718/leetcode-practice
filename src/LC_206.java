
// Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// Iterative
class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;    
  }
  // Recursion
  public ListNode reverseListRecursion(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = reverseListRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}

