package LINKEDLIST.MediumProblemsOfLL;

public class DeleteMiddleOfLL {
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

    //Brute Force
    public static Node deleteMiddle(Node head) {
        Node temp = head;
        int n = 0;
        
        // Loop to count the number of nodes in the linked list
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        
        // Calculate the index of the middle node
        int res = n / 2;
        
        // Reset the temporary node to the beginning of the linked list
        temp = head;
        
        // Loop to find the middle node to delete
        while (temp != null) {
            res--;
            // If the middle node is found
            if (res == 0) {
                Node middle = temp.next;
                
                // Adjust pointers to skip the middle node
                temp.next = temp.next.next;
                
                // Exit the loop after deleting the middle node
                break;
            }
            // Move to the next node in the linked list
            temp = temp.next;
        }
        return head;
    }

    //Optimal Solution[the Tortoise and Hare Algorithm]
    static Node deleteMiddle2(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Original Linked List: ");
        printLL(head);

        //head = deleteMiddle(head);
        head = deleteMiddle2(head);

        System.out.print("Updated Linked List: ");
        printLL(head);
    }
}
