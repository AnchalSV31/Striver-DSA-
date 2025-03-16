package LINKEDLIST.LLHard;

public class ReverseNodesInKGroups {
    static class Node{
        int data;
        Node next;

        Node(int data, Node next){
            this.data = data;
            this.next =next;
        }

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node reverseNodesInKGroups(Node head){
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            Node front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }

    static Node getKthNode(Node temp, int k) {
        // Decrement K as we already
        // start from the 1st node
        k -= 1;
        
        // Decrement K until it reaches
        // the desired position
        while (temp != null && k > 0) {
            // Decrement k as temp progresses
            k--;
            temp = temp.next;
        }
        return temp;
    }

    static Node kReverse(Node head, int k) {
        Node temp = head;
        Node prevLast = null;
        
        while (temp != null) {
            Node kThNode = getKthNode(temp, k);
            if (kThNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }
            Node nextNode = kThNode.next;
            kThNode.next = null;
            reverseNodesInKGroups(temp);
            
            if (temp == head) {
                head = kThNode;
            } else {
                prevLast.next = kThNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(2);

        System.out.print("Original Linked List: ");
        printLL(head);

        head = kReverse(head, 4);

        System.out.print("Reversed Linked List: ");
        printLL(head);
    }

}
