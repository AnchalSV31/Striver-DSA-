package LINKEDLIST.LLHard;

public class MergeKSortedList {
    static class Node {
        int data;
        Node next;
        Node child;
        Node() {
            data = 0;
            next = null;
            child = null;
        }

        Node(int x) {
            data = x;
            next = null;
            child = null;
        }

        Node(int x, Node nextNode, Node childNode) {
            data = x;
            next = nextNode;
            child = childNode;
        }
    }
   
    
}
