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
    ListNode prevL=null;ListNode dummy=null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count=1;  ListNode prevR=null;
         ListNode left1=head; dummy=head;
        while(head!=null){
            if(count<left){
                prevL=head;
                left1=head.next;
            }
            if(count>=left&&count<=right){
                prevR=head.next;
            }
            if(count>right) break;
            count++;
            head=head.next;
        }
        //System.out.println(prevL.val+" "+count+" "+prevR.val+left1.val);
        reverse(left1,prevR,left-1,right);
        return dummy;  
    }
    private void reverse(ListNode curr,ListNode prev,int count,int right){
        if(count==right){
            if(prevL==null) dummy=prev;
            else
            prevL.next=prev;
            return;
        }
       // System.out.println(curr.val+" "+prev.val);
        ListNode futu=curr.next;
        curr.next=prev;
        reverse(futu,curr,count+1,right);
    }
}