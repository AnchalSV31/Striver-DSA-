package LINKEDLIST.DLL;

public class DLL {
    public static class Node {
        public int data;
        public Node next;
        public Node back;

        public Node(int data1, Node next1, Node back1) {
            data = data1;
            next = next1;
            back = back1;
        }

        public Node(int data1) {
            data = data1;
            next = null;
            back = null;
        }
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

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next; 
        }
        System.out.println();
    }
    
    private static Node insertAtTail(Node head, int k) {
        Node newNode = new Node(k);
    
        if (head == null) {
            return newNode;
        }
    
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
    
        current.next = newNode;
        newNode.back = current;
    
        return head;
    }

    private static Node insertBeforeHead(Node head, int val){
        Node newHead = new Node(val, head, null);
        head.back=newHead;

        return newHead;
    }

    private static Node insertBeforeTail(Node head, int val){
        if(head.next==null){
            return insertBeforeHead(head, val);
        }
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        Node prev=tail.back;
        Node newNode = new Node(val, tail, prev);
        prev.next = newNode;
        tail.back = newNode;
        return head;
    }

    private static Node insertBeforeKthElement(Node head, int k, int val){
        if(k==1){
            return insertBeforeHead(head, val);
        }
        Node temp=head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            if(cnt==k) break;
            temp=temp.next;
        }
        Node prev=temp.back;
        Node newNode=new Node(val, temp, prev);
        prev.next= newNode;
        temp.back=newNode;
        return head;
    }

    public static void insertBeforeNode(Node node, int val){
        Node prev=node.back;
        Node newNode=new Node(val, node, prev);
        prev.next=newNode;
        node.back=newNode;
    }
    
    private static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        Node prev = head;
        head = head.next;
        
        head.back = null; 
        prev.next = null; 
        
        return head;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null; 
        }
        
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        
        Node newtail = tail.back;
        
        newtail.next = null;
        tail.back = null;
        
        return head;
    }

    private static Node deleteAtK(Node head, int k){
        if(head==null){
            return null;
        }
        int cnt=0;
        Node kNode=head;
        while(kNode!=null){
            cnt++;
            if(cnt==k) break;
            kNode=kNode.next;
        }
        Node prev=kNode.back;
        Node front=kNode.next;

        if(prev==null && front==null){   //k is the only element
            return null;
        }
        else if(prev==null){     //k is head
            return deleteHead(head);
        }
        else if(front==null){    //k is tail
            return deleteTail(head);
        }
        prev.next=front;
        front.back=prev;

        kNode.next=null;
        kNode.back=null;

        return head;
    }

    //remove given node[it should never be head of DLL]
    public static void deleteNode(Node temp){
        Node prev= temp.back;
        Node front=temp.next;

        if(front==null){
            prev.next=null;
            temp.back=null;
            return;
        }
        prev.next=front;
        front.back=prev;

        temp.next=temp.back=null;
    }


    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 4, 7};
        Node head = convertArr2DLL(arr);
        print(head);

        insertBeforeNode(head.next.next, 100);
        print(head);

        // head= insertBeforeKthElement(head, 1, 10);
        // print(head);

        // head = insertBeforeTail(head, 10);
        // print(head);

        // head = insertBeforeHead(head, 10);
        // print(head);
    
        // deleteNode(head.next);
        // print(head);

        // head = insertAtTail(head, 10); 
        // print(head);

        // head = deleteHead(head);
        // print(head);

        // head = deleteTail(head);
        // print(head);

        // head = deleteAtK(head, 2);
        // print(head);


    }
}