package LINKEDLIST.DLLProblems;

public class DeleteAllOccurences {
    public static class Node {
        public int data;
        public Node next;
        public Node prev;

        public Node(int data1, Node next1, Node prev1) {
            data = data1;
            next = next1;
            prev = prev1;
        }

        public Node(int data1) {
            data = data1;
            next = null;
            prev = null;
        }
    }

    //TC:O(N) SC:O(1)
    public static Node deleteAllOccurences(Node head, int key){
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                if(temp==head){
                    head=head.next;
                }
                Node nextNode= temp.next;
                Node prevNode=temp.prev;
                if(nextNode!=null) nextNode.prev=prevNode;
                if(prevNode!=null) prevNode.next=nextNode;
                temp=nextNode;
            }
            else{
                temp=temp.next;
            }
        }
        return head;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
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
        int[] arr = {10, 5, 10, 6, 10, 4};
        Node head = convertArr2DLL(arr);
        System.out.println("Doubly Linked List Initially: ");
        print(head);

        head = deleteAllOccurences(head, 10);
        print(head);

    }
}
