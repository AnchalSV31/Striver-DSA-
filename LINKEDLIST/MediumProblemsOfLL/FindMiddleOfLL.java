package LINKEDLIST.MediumProblemsOfLL;

public class FindMiddleOfLL {
    static class Node {
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

    //Brute force
    static Node findMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int mid = count / 2 + 1;
        temp = head;

        while (temp != null) {
            mid = mid - 1;
            if (mid == 0){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    //Optimal Code [the Tortoise and Hare Algorithm]
    static Node findMiddle2(Node head) {
        Node slow = head; 
        Node fast = head;   
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;  
            slow = slow.next;        
        }
        return slow;  
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        // Node middleNode = findMiddle(head);
        Node middleNode = findMiddle2(head);
        System.out.println("The middle node value is: " + middleNode.data);
    }
}
