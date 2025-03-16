package LINKEDLIST.DLLProblems;

public class RemoveDuplicatesFromSortedDLL {
    public static class Node {
        public int val;
        public Node next;
        public Node prev;

        public Node(int data1, Node next1, Node prev1) {
            val = data1;
            next = next1;
            prev = prev1;
        }

        public Node(int data1) {
            val = data1;
            next = null;
            prev = null;
        }
    }

    public static Node removeDuplicatesFromSortedDLL(Node head){
        Node temp=head;
        while(temp!=null && temp.next!=null){
            Node nextNode=temp.next;
            while(nextNode!=null && nextNode.val==temp.val){
                nextNode=nextNode.next;
            }
            temp.next=nextNode;
            if(nextNode!=null) nextNode.prev=temp;
            temp=temp.next;
        }
        return head;
    } 

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next; 
        }
        System.out.println();
    }

    private static Node convertArr2DLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3, 4};

        Node head = convertArr2DLL(arr);
        System.out.println("Doubly Linked List Initially: ");
        print(head);
    
        head = removeDuplicatesFromSortedDLL(head);
        print(head);
    }
}
