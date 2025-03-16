package LINKEDLIST.MediumProblemsOfLL;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLoop {
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
    public static int lengthOfLoop(Node head) {
        Map<Node, Integer> visitedNodes = new HashMap<>();
        
        Node temp = head;
        
        int timer = 0;

        while (temp != null) {
            if (visitedNodes.containsKey(temp)) {
                int loopLength = timer - visitedNodes.get(temp);
                return loopLength;
            }
            visitedNodes.put(temp, timer);
            temp = temp.next;
            timer++;
        }
        return 0;
    }

    //Optimal Solution[Tortoise and Hare Algorithm]
    static int findLength(Node slow, Node fast){
        int cnt = 1;
        fast = fast.next;
        while(slow!=fast){
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }

    static int lengthOfLoop2(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;  
            fast = fast.next.next; 

            if (slow == fast) {
                return findLength(slow, fast);
            }
        }
        return 0; 
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
        
        fifth.next = second; 

        // int loopLength = lengthOfLoop(head);
        int loopLength = lengthOfLoop2(head);

        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }
}
