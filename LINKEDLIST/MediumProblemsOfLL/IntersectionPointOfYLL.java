package LINKEDLIST.MediumProblemsOfLL;

import java.util.HashSet;

class Node {
    int num;
    Node next;
    Node(int val) {
        num = val;
        next = null;
    }
}

public class IntersectionPointOfYLL {
    //Brute Force
    static Node insertNode(Node head,int val) {
        Node newNode = new Node(val);
        
        if(head == null) {
            head = newNode;
            return head;
        }
        
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        
        temp.next = newNode;
        return head;
    }
    
    //brute force
    static Node intersectionPresent(Node head1,Node head2) {
        while(head2 != null) {
            Node temp = head1;
            while(temp != null) {
                //if both nodes are same
                if(temp == head2) return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        //intersection is not present between the lists return null
        return null;
    }

    //Approach 2
    static Node intersectionPresent2(Node head1,Node head2) {
        HashSet<Node> st=new HashSet<>();
        while(head1 != null) {
            st.add(head1);
            head1 = head1.next;
        }
        while(head2 != null) {
            if(st.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;
    }

    //APPROACH 3
    static int getDifference(Node head1,Node head2) {
        int len1 = 0,len2 = 0;
            while(head1 != null || head2 != null) {
                if(head1 != null) {
                    ++len1; head1 = head1.next;
                }
                if(head2 != null) {
                    ++len2; head2 = head2.next;
                }
            }
            return len1-len2;//if difference is neg-> length of list2 > length of list1 else vice-versa
    }
    //utility function to check presence of intersection
    static Node intersectionPresent3(Node head1,Node head2) {
      int diff = getDifference(head1,head2);
            if(diff < 0) 
                while(diff++ != 0) head2 = head2.next; 
            else while(diff-- != 0) head1 = head1.next;
            while(head1 != null) {
                if(head1 == head2) return head1;
                head2 = head2.next;
                head1 = head1.next;
            }
            return head1;
    }


    //OPTIMAL APPROACH
    static Node intersectionPresent4(Node head1,Node head2) {
        Node d1 = head1;
        Node d2 = head2;
        
        while(d1 != d2) {
            d1 = d1 == null? head2:d1.next;
            d2 = d2 == null? head1:d2.next;
        }
        
        return d1;
    }

    static void printList(Node head) {
        while(head.next != null) {
        System.out.print(head.num+"->");
            head = head.next;
        }
        System.out.println(head.num);
    }

    public static void main(String args[]) {
        Node head = null;
        head=insertNode(head,1);
        head=insertNode(head,3);
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,4);
        Node head1 = head;
        head = head.next.next.next;

        Node headSec = null;
        headSec=insertNode(headSec,3);

        Node head2 = headSec;
        headSec.next = head;

        System.out.print("List1: "); printList(head1);
        System.out.print("List2: "); printList(head2);

        // Node answerNode = intersectionPresent(head1,head2);
        // Node answerNode = intersectionPresent2(head1,head2);
        //Node answerNode = intersectionPresent3(head1,head2);
        Node answerNode = intersectionPresent4(head1,head2);

        if(answerNode == null){
            System.out.println("No intersection\n");
        }else{
            System.out.println("The intersection point is "+answerNode.num);
        }
    }
}
