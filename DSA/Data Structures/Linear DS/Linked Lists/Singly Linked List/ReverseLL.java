// URL: https://leetcode.com/problems/reverse-linked-list/
// Learning resources: 
// -- https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118786/offering/1382019
// -- https://www.youtube.com/watch?v=ugQ2DVJJroc

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    // APPROACH-1: Iterative ; Time: O(n) ; Space: O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    // APPROACH-2: Recursive ; Time: O(n) ; Space: O(n) -- Stack space.
    /*
     * STEPS: -
     * 1. Recursively go to the end of the LL and store the tail node. This also
     * returns the last node as `head`.
     * 2. Now in the last-but-one call, manipulate the pointers of the `head` and
     * `nextHead` nodes.
     * 3. Finally, return the tail node all the way back to the beginning.
     */
    public ListNode reverseList(ListNode head) {
        // Base condition
        if (head == null || head.next == null)
            return head;

        // Step-1
        ListNode tail = reverseList(head.next);

        // Step-2
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = null;

        // Step-3
        return tail;
    }
}