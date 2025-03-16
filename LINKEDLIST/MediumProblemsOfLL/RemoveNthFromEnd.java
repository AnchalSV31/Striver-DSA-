package LINKEDLIST.MediumProblemsOfLL;

class Node {
    public int data;
    public Node next;
    
    public Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }
    public Node(int data1) {
        data = data1;
        next = null;
    }
}
public class RemoveNthFromEnd {
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    //Brute Force
    public static Node DeleteNthNodefromEnd(Node head, int N) {
        if (head == null) {
            return null;
        }
        int cnt = 0;
        Node temp = head;

        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        if (cnt == N) {
            Node newhead = head.next;
            head = null;
            return newhead;
        }

        // Calculate the position of the node to delete (res)
        int res = cnt - N;
        temp = head;

        // Traverse to the node just before the one to delete
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        // Delete the Nth node from the end
        Node delNode = temp.next;
        temp.next = temp.next.next;
        delNode = null;
        return head;
    }

    
    //Optimal Approach
    public static Node DeleteNthNodefromEnd2(Node head, int N) {
        Node fastp = head;
        Node slowp = head;

        // Move the fastp pointer N nodes ahead
        for (int i = 0; i < N; i++)
            fastp = fastp.next;

        // If fastp becomes null, the Nth node from the end is the head
        if (fastp == null)
            return head.next;

        // Move both pointers until fastp reaches the end
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

        // Delete the Nth node from the end
        Node delNode = slowp.next;
        slowp.next = slowp.next.next;
        delNode = null;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int N = 3;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);

        //head = DeleteNthNodefromEnd(head, N);
        head = DeleteNthNodefromEnd2(head, N);
        printLL(head);
    }
}

