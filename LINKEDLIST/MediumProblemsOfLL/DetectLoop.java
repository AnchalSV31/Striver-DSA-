package LINKEDLIST.MediumProblemsOfLL;

import java.util.HashMap;
import java.util.Map;

public class DetectLoop {
    static class Node {
        public int data;   
        public Node next;  
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    //Brute Force Approach
    public static boolean detectLoop(Node head) {
        Node temp = head;
        Map<Node, Integer> nodeMap = new HashMap<>();
        while (temp != null) {
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            nodeMap.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    //Optimal Approach[the Tortoise and Hare Algorithm]
    public static boolean detectLoop2(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;  
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = third;

        // if (detectLoop(head)) {
        if(detectLoop2(head)){
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
