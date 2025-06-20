package LINKEDLIST.MediumProblemsOfLL;

import java.util.HashMap;

//Starting point of loop in a Linked List

public class DetectStartingOfLoop {
    static class Node {
        int data;  
        Node next;   
        Node(int data1, Node next1) {
            data = data1;
            next = next1;
        }
        Node(int data1) {
            data = data1;
            next = null;
        }
    }

    //Brute Force
    public static Node firstNode(Node head) {
        Node temp = head;
        HashMap<Node, Integer> nodeMap = new HashMap<>();

        while (temp != null) {
            if (nodeMap.containsKey(temp)) {
                return temp;
            }
            nodeMap.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }

    //Optimal Solution[The Tortoise and Hare approach]
    public static Node firstNode2(Node head) {
        Node slow = head;  
        Node fast = head;  
    
        while (fast != null && fast.next != null) {
            slow = slow.next;       
            fast = fast.next.next;  
            if (slow == fast) {
                slow = head; 
                while (slow != fast) {
                    slow = slow.next;  
                    fast = fast.next;  
                }
                return slow;  
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;
        Node node5 = new Node(5);
        node4.next = node5;
        node5.next = node2;

        Node head = node1;

        //Node loopStartNode = firstNode(head);
        Node loopStartNode = firstNode2(head);

        if (loopStartNode != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
