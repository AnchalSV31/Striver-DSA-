package LINKEDLIST.LLHard;

import java.util.*;

public class SortLLHard {
    static class Node {
        int data;
        Node next;
    
        Node(int data, Node next){
            this.data=data;
            this.next=next;
        }
    
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    //Brute Force
    public static Node sortLL(Node head){
        List<Integer> arr = new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            arr.add(temp.data);
            temp=temp.next;
        }
        Collections.sort(arr);
        temp=head;
        for(int i=0; i<arr.size(); i++){
            temp.data=arr.get(i);
            temp=temp.next;
        }
        return head;
    }

    //Optimal approach
    public static Node sortLL2(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        
        Node middle = findMiddle(head);
        
        Node right = middle.next;
        middle.next = null;
        Node left = head;

        left = sortLL(left);
        right = sortLL(right);
        
        return mergeTwoSortedLL(left, right);
    }

    static Node findMiddle(Node head){
        if (head == null || head.next == null) {
            return head;
        }
    
        Node slow = head;
        Node fast = head.next;
    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    static Node mergeTwoSortedLL(Node list1, Node list2) {
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

    static void printLL(Node head) {
        while (head.next != null) {
          System.out.print(head.data + "->");
          head = head.next;
        }
        System.out.println(head.data);
    }
    
    public static void main(String args[]) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);

        System.out.print("Linked List: ");
        printLL(head);

       // Node newHead = sortLL(head);
        Node newHead = sortLL2(head);

        printLL(newHead); 
    }
}
