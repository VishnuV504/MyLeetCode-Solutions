/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ptr = head;
        ListNode prev = new ListNode(-1);
        ListNode dummy = prev;
        while(ptr!=null)
        {
            if(ptr.val==val)
                ptr=ptr.next;
            else
            {
                prev.next=ptr;
                prev=prev.next;
                ptr=ptr.next;
            }
        }
        prev.next=null;
        return dummy.next;
        
    }
}