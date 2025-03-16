package LINKEDLIST.LLHard;

public class FlatteningLLOptimalApproach {
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

    public static Node merge(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }

        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }

        // Break the last node's link to prevent cycles
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }

        return dummyNode.child;
    }

    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mergedHead = flattenLinkedList(head.next);
        head = merge(head, mergedHead);
        return head;
    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }

    public static void printOriginalLL(Node head, int depth) {
        while (head != null) {
            System.out.print(head.data);

            // If child exists, recursively
            // print it with indentation
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLL(head.child, depth + 1);
            }

            // Add vertical bars
            // for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.child = new Node(14);

        head.next = new Node(10);
        head.next.child = new Node(4);

        head.next.next = new Node(12);
        head.next.next.child = new Node(20);
        head.next.next.child.child = new Node(13);

        head.next.next.next = new Node(7);
        head.next.next.next.child = new Node(17);

        System.out.println("Original linked list:");
        printOriginalLL(head, 0);
        Node flattened = flattenLinkedList(head);
        System.out.print("\nFlattened linked list: ");
        printLL(flattened);
    }
}
