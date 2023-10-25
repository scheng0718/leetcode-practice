var isPalindrome = function(head) {
    if (!head || head.next === null) return true;
    const array = [];
    while (head !== null) {
        array.push(head.val);
        head = head.next;
    }
    let left = 0;
    let right = array.length - 1;
    while (left <= right) {
        if (array[left] !== array[right]) return false;
        left++;
        right--;
    }
    return true;    
};
// Optimization with O(1) Space
function isPalindromeOptimized (head) {
    if (!head || !head.next) return true;
    let slow = head;
    let fast = head;
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
    }    
    let current = slow;
    let prev = null;
    while (current) {
        let next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    let head1 = head;
    let head2 = prev;
    while (head1 && head2) {
        if (head1.val !== head2.val) return false;
        head1 = head1.next;
        head2 = head2.next;
    }
    return true;
};