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
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next==null)
            return head;
        int count=1;
        ListNode p = head;
        while(count!=k)
        {
            p=p.next;
            ++count;
        }
       // System.out.println(count);
        ListNode q= p;
        ListNode r= p;
        int count2=1;
        while(q.next!=null)
        {
            count++;
            q=q.next;
        }
       //System.out.println(count +" "+k);
        if(count==k)
        {
            int temp = head.val;
            while(r.next!=null)
            {
                r=r.next;
            }
            head.val=r.val;
            r.val = temp;
            
        }
        else
        {
            int flag=0;
            ListNode s= head;
            while(count2!=count-k+1)
            {
                if(s==null)
                {   flag=1;
                    break;
                }
                count2++;
                s=s.next;
            }
            if(flag==0)
            {
                int temp = s.val;
                s.val=p.val;
                p.val= temp;
                return head;
            }
        }
            return head;

        
    }
}