package LINKEDLIST.MediumProblemsOfLL;

import java.util.Stack;

class Node {
    int data;      
    Node next;     
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLL {
    //Brute Force
    public static Node reverseLinkedList(Node head) {
        Node temp = head;       
        Stack<Integer> stack = new Stack<>(); 
        while (temp != null) {
            stack.push(temp.data); 
            temp = temp.next;      
        }
        temp = head;  
        while (temp != null) {
            temp.data = stack.pop();  
            temp = temp.next;         
        }
        return head;  
    }

    //Optimal Approach 1(Iterative)
    public static Node reverseLinkedList2(Node head){
        Node temp = head;  
        Node prev = null;  
   
       while(temp != null){  
            Node front = temp.next;  
            temp.next = prev;  
            prev = temp;  
            temp = front; 
        }
        return prev;  
    }

    //Optimal Approach 2 [recursive]
    public static Node reverseLinkedList3(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseLinkedList3(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }


    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);

        System.out.print("Original Linked List: ");
        printLinkedList(head);
        // head = reverseLinkedList(head);
        //head = reverseLinkedList2(head);
        head = reverseLinkedList3(head);
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}
