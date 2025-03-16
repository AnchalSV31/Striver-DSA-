package LINKEDLIST.LLHard;

import java.util.HashMap;

public class CloneLL {
    static class Node {
        int data;
        Node next;
        Node random;
    
        Node() {
            this.data = 0;
            this.next = null;
            this.random = null;
        }
    
        Node(int x) {
            this.data = x;
            this.next = null;
            this.random = null;
        }
    
        Node(int x, Node nextNode, Node randomNode) {
            this.data = x;
            this.next = nextNode;
            this.random = randomNode;
        }
    }

    //Brute Force
    public static Node cloneLL(Node head) {
        Node temp = head;
        HashMap<Node, Node> map = new HashMap<>();

        while (temp != null) {
            Node newNode = new Node(temp.data);
            map.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }

    //Optimal Code
    static Node cloneLL2(Node head) {
        if (head == null) return null;
    
        // Step 1: Insert copy of nodes in between
        insertCopyInBetween(head);
        // Step 2: Connect random pointers of copied nodes
        connectRandomPointers(head);
        // Step 3: Retrieve the deep copy of the linked list
        return getDeepCopyList(head);
    }

    static void insertCopyInBetween(Node head) {
        Node temp = head;
        while (temp != null) {
            Node nextElement = temp.next;
            // Create a new node with the same data
            Node copy = new Node(temp.data);
    
            // Point the copy's next to the original node's next
            copy.next = nextElement;
    
            // Point the original node's next to the copy
            temp.next = copy;
    
            // Move to the next original node
            temp = nextElement;
        }
    }
    
    static void connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            // Access the copied node
            Node copyNode = temp.next;
    
            // If the original node has a random pointer
            if (temp.random != null) {
                // Point the copied node's random to the corresponding copied random node
                copyNode.random = temp.random.next;
            } else {
                // Set the copied node's random to null if the original random is null
                copyNode.random = null;
            }
    
            // Move to the next original node
            temp = temp.next.next;
        }
    }
    
    // Function to retrieve the deep copy of the linked list
    static Node getDeepCopyList(Node head) {
        Node temp = head;
        // Create a dummy node
        Node dummyNode = new Node(-1);
        // Initialize a result pointer
        Node res = dummyNode;
    
        while (temp != null) {
            // Creating a new List by pointing to copied nodes
            res.next = temp.next;
            res = res.next;
    
            // Disconnect and revert back to the initial state of the original linked list
            temp.next = temp.next.next;
            temp = temp.next;
        }
    
        // Return the deep copy of the list starting from the dummy node
        return dummyNode.next;
    }
    
    public static void printClonedLL(Node head) {
        while (head != null) {
            System.out.print("Data: " + head.data);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.data);
            } else {
                System.out.print(", Random: nullptr");
            }
            System.out.println();
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
        printClonedLL(head);

        //Node clonedList = cloneLL(head);
        Node clonedList = cloneLL2(head);


        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLL(clonedList);
    }
}
