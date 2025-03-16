package LINKEDLIST.MediumProblemsOfLL;

import java.util.Stack;


public class IsPalindrome {
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
    public static boolean isPalindrome(Node head){
        Stack<Integer> st = new Stack<>();
        Node temp=head;
        while(temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.data!=st.peek()){
                return false;
            }
            st.pop();
            temp=temp.next;
        }
        return true;
    }

    //Optimal Approach
    public static Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
    
        Node slow = head;
        Node fast = head;
    
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        Node newHead = reverseLL(slow.next);
        Node first = head;
        Node second = newHead;
        while (second != null) {
            if (first.data != second.data) {
                reverseLL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLL(newHead);
        return true;
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
        Node head=new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        System.out.print("Original Linked List: ");
        printLL(head);

        if (isPalindrome2(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
