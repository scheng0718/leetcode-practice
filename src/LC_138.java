import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
  public Node copyRandomList(Node head) {
    if (head == null) return null;
    Map<Node, Node> map = new HashMap<>();
    Node curr = head;
    while (curr != null) {
        map.put(curr, new Node(curr.val));
        curr = curr.next;
    }
    curr = head;
    while (curr != null) {
        map.get(curr).next = map.get(curr.next);
        map.get(curr).random = map.get(curr.random);
        curr = curr.next;
    }
    return map.get(head);    
  }
  public Node copyRandomListIterative(Node head) {
    if (head == null) return null;
    Node curr = head;
    while (curr != null) {
        Node newNode = new Node(curr.val);
        newNode.next = curr.next;
        curr.next = newNode;
        curr = curr.next.next;    
    }
    curr = head;
    while (curr != null) {
        if (curr.random != null) {
            curr.next.random = curr.random.next;
        }
        curr = curr.next.next;
    }
    curr = head;
    Node dummy = new Node(0);
    Node curr1 = dummy;
    while (curr != null) {
        curr1.next = curr.next;
        curr.next = curr.next.next;
        curr = curr.next;
        curr1 = curr1.next;
    }
    return dummy.next;    
  }
}