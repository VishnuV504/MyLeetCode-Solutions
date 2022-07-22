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
    public ListNode partition(ListNode head, int x) {
        return solve(head,x);
    }
    private ListNode solve(ListNode head,int x){
        ListNode posS=null;ListNode head2=head;ListNode posG=null;
        while(head!=null){
            if(head.val<x){
                posS=head;
                break;
            }
            head=head.next;
        }
        head=head2;
        while(head!=null){
            if(head.val>=x){
                posG=head;
                break;
            }
            head=head.next;
        }
        if(posG==null)return posS;
        if(posS==null)return posG;
        head=head2;ListNode dummy=new ListNode(-1);ListNode dummy2=new ListNode(-1);
        while(head!=null){
            if(head.val<x){
                dummy.next=head;
                dummy=dummy.next;
            }
            else{
                dummy2.next=head;
                dummy2=dummy2.next;
            }
            head=head.next;
        }
        dummy2.next=null;
        dummy.next=posG;
        return posS;
    }
}