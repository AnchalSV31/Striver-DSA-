package LINKEDLIST.LLHard;

public class MergeTwoSortedLL{
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

    static Node createLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    static void printLL(Node head) {
        while (head.next != null) {
          System.out.print(head.data + "->");
          head = head.next;
        }
        System.out.println(head.data);
    }

    public static void main(String[] args) {
        int[] list1Arr = {1, 3, 5, 7};
        int[] list2Arr = {2, 4, 6, 8};

        Node list1 = createLL(list1Arr);
        Node list2 = createLL(list2Arr);

        System.out.println("List 1:");
        printLL(list1);

        System.out.println("List 2:");
        printLL(list2);

        Node mergedList = mergeTwoSortedLL(list1, list2);

        System.out.println("Merged List:");
        printLL(mergedList);
    }
}
