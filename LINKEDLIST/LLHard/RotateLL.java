package LINKEDLIST.LLHard;

public class RotateLL {
    static class Node {
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

    static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) return head;
        for (int i = 0; i < k; i++) {
          Node temp = head;
          while (temp.next.next != null) temp = temp.next;
          Node end = temp.next;
          temp.next = null;
          end.next = head;
          head = end;
        }
        return head;
    }

    //Optimal solution
    public Node rotateRight2(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;
    
        // Step 1: Find the length of the list and the tail node
        Node tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
    
        // Step 2: Compute the effective number of rotations
        k = k % length;
        if (k == 0) return head;
    
        // Step 3: Make the list circular
        tail.next = head;
    
        // Step 4: Find the new tail and head
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }
    
        // Step 5: Break the circle and return the new head
        Node newHead = tail.next;
        tail.next = null;
    
        return newHead;
    }
    
    static void printLL(Node head) {
        while (head.next != null) {
          System.out.print(head.data + "->");
          head = head.next;
        }
        System.out.println(head.data);
    }
    
    public static void main(String args[]) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(2);

        System.out.print("Original Linked List: ");
        printLL(head);
    
        int k = 2;
        Node newHead = rotateRight(head, k);
        System.out.println("After " + k + " iterations: ");
        printLL(newHead); 
    
    }
}
