package LINKEDLIST.MediumProblemsOfLL;

public class Add1ToLL {
    static class Node{
        int data;
        Node next;
    
        Node(int data, Node next){
            this.data=data;
            this.next=next;
        }
    
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    
    //Brute Force
    public static Node add1ToLL(Node head){
        if (head == null) {
            return new Node(1);
        }

        head=reverse(head);
        Node temp=head;
        int carry=1;

        while(temp!=null){
            temp.data=temp.data+carry;
            if(temp.data<10){
                carry=0;
                break;
            }
            else{
                temp.data=0;
                carry=1;
            }
            temp=temp.next;
        }
        
        if(carry==1){
            Node newNode = new Node(1);
            head=reverse(head);
            newNode.next=head;
            return newNode;
        }
        head=reverse(head);
        return head;
    }

    public static Node reverse(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    //Optimal Approach
    public static Node add1ToLL2(Node head){
        if (head == null) {
            return new Node(1); 
        }
        int carry= helper(head);
        if(carry==1){
            Node newNode=new Node(1);
            newNode.next=head;
            return newNode;
        }
        return head;
    }
    
    public static int helper(Node temp){
        if(temp==null){
            return 1;
        }
        int carry=helper(temp.next);
        temp.data=temp.data+carry;
        if(temp.data<10){
            return 0;
        }
        else{
            temp.data=0;
            return 1;
        }
    }

    public static void printLL(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(9);
        System.out.println("Initial LinkedList : ");
        printLL(head);
        // head=add1ToLL(head);
        head=add1ToLL2(head);
        System.out.println("Linked List after adding 1 : ");
        printLL(head);
    }
}
