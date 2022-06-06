/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dup1=headA;
        ListNode dup2=headB; int length1=0; int length2=0;
        while(headA!=null)
        {
            length1++;
            headA=headA.next;
        }
        while(headB!=null)
        {
            length2++;
            headB=headB.next;
        }
        while(length1!=length2)
        {
            if(length1>length2)
            {
                length1--;
                dup1=dup1.next;
            }
            else
            {
                length2--;
                dup2=dup2.next;
            }
        }
        while(dup1!=null)
        {
            if(dup1==dup2)
                return dup1;
            dup1=dup1.next;
            dup2=dup2.next;
        }
        return null;
        
    }
}