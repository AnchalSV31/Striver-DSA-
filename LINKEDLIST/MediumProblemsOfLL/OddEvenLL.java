package MediumProblemsOfLL;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
        next=null;
    }
}

public class OddEvenLL {
    static ListNode head, tail;
    static void PrintList(ListNode head){
        ListNode curr=head;
        for(;curr!=null; curr=curr.next){
            System.out.print(curr.val+"-->");
        }
        System.out.println("null");
    }
    static void InsertAtLast(int value){
        ListNode newnode = new ListNode(value);
        if(head==null){
            head=newnode;
            tail=newnode;
        }else{
            tail=tail.next=newnode;
        }
    }
    static ListNode SegregatetoOddEven(){
        ListNode oddHead = new ListNode(-1), oddTail = oddHead;
        ListNode evenHead = new ListNode(-1), evenTail = evenHead;
        ListNode curr = head, temp;
        while(curr!=null){
            temp=curr;
            curr=curr.next;
            temp.next=null;
            if(temp.val%2!=0){
                oddTail.next=temp;
                oddTail = temp;
            }else{
                evenTail.next = temp;
                evenTail=temp;
            }
        }
        evenTail.next=oddHead.next;
        return evenHead.next;
    }

    public static void main(String args[]){
        InsertAtLast(1);
        InsertAtLast(2);
        InsertAtLast(3);
        InsertAtLast(4);
        System.out.println("Initial LinkedList : ");
        PrintList(head);
        ListNode newHead = SegregatetoOddEven();
        System.out.println("LinkedList After Segregration ");
        PrintList(newHead);
    }
}
