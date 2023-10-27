/**
 * // Definition for a Node.
 * function Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {Node} head
 * @return {Node}
 */
var copyRandomList = function(head) {
  if (!head) return null;
  let curr = head;
  while (curr) {
    let newNode = new Node(curr.val);
    newNode.next = curr.next;
    curr.next = newNode;
    curr = curr.next.next;
  }
  curr = head;
  while (curr) {
    if (curr.random) {
    curr.next.random = curr.random.next;
    }
    curr = curr.next.next;
  }
  let dummy = new Node(0);
  curr = head;
  let curr1 = dummy;
  while (curr) {
    curr1.next = curr.next;
    curr.next = curr.next.next;
    curr = curr.next;
    curr1 = curr1.next;
  }    
  return dummy.next;    
};

var copyRandomListMap = function(head) {
  if (!head) return null;
  let map = new Map();
  let currNode = head;
  while (currNode) {
    map.set(currNode, new Node(currNode.val));
    currNode = currNode.next;
  }
}