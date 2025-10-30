package LINKEDLIST.LLHard;
import java.util.*;

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
   
    //BRUTE FORCE
    //TC:O(N*K)+M*logM+M  SC:O(M)+O(M)
    public static Node  mergeKSortedList1(ArrayList<Node> lists){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<lists.size(); i++){
            Node temp=lists.get(i);
            while(temp!=null){
                arr.add(temp.data);
                temp=temp.next;
            }
        }
        Collections.sort(arr);
        Node head=convertArrToLL(arr);
        return head;  
    }
    
    //OPTIMAL APPROACH(using approach merge 2 sorted LL)
    //TC: ~O(N*(K*K+1)/2)  ~ O(N^3)  SC:O(1)
    public static Node mergeKSortedList2(ArrayList<Node> lists){
        Node head=lists.get(0);
        for(int i=1; i<lists.size(); i++){
            head=mergeTwoSortedLL(head,lists.get(i));
        }
        return head;
    }

    public static Node mergeTwoSortedLL(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
    
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next; 
        }
    
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return dummyNode.next;
    }

    //OPTIMAL APPROACH (using min-heap)
    //TC:O(N*logK) SC:O(K)
    public static Node mergeKSortedList3(ArrayList<Node> lists){
        // Custom comparator to sort by node data
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));

        // Step 1: Add the head of each list to the heap
        for (Node head : lists) {
            if (head != null) pq.offer(head);
        }

        // Step 2: Use a dummy node to simplify list construction
        Node dummy = new Node(-1);
        Node tail = dummy;

        // Step 3: Extract the smallest node, then push its next node to the heap
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            tail.next = curr;
            tail = tail.next;

            if (curr.next != null) pq.offer(curr.next);
        }

        // Step 4: Return merged list
        return dummy.next;
    }



    public static Node convertArrToLL(ArrayList<Integer> arr) {
        if (arr.isEmpty()) return null;

        Node head = new Node(arr.get(0));
        Node curr = head;

        for (int i = 1; i < arr.size(); i++) {
            curr.next = new Node(arr.get(i));
            curr = curr.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        ArrayList<Node> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        // Node merged = mergeKSortedList1(lists);
        // Node merged = mergeKSortedList2(lists);
        Node merged = mergeKSortedList3(lists);
        printList(merged);
    }
}
