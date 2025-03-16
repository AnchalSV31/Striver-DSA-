package LINKEDLIST.MediumProblemsOfLL;

//gfg
//sort linked list of 0's, 1's and 2's
public class SortLL {
    class ListNode {
        int data;
        ListNode next;
        ListNode(int x) { data = x; }
    }
    public ListNode sortLL(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode zero=zeroHead;
        ListNode one=oneHead;
        ListNode two=twoHead;

        ListNode temp= head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;
            }
            else{
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        zero.next = oneHead.next!=null ?oneHead.next : twoHead.next;
        one.next=twoHead.next;
        two.next=null;
        
        ListNode newHead = zeroHead.next;

        return newHead;
    }
    
}
