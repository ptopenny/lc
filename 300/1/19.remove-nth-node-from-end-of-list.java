/*
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (33.99%)
 * Total Accepted:    241K
 * Total Submissions: 709.1K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * 
 * ⁠  Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * ⁠  After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode tail = head;
        for (int i = 0; i < n; i++) tail = tail.next;
        ListNode cur = res;
        while (tail != null) {
            cur = cur.next;
            tail = tail.next;
        }
        cur.next = cur.next.next;
        return res.next;
    }
}
