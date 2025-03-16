package LINKEDLIST.DLLProblems;

import java.util.ArrayList;
import java.util.List;

public class AllPairsWithGivenSum{
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

    //Brute Force
    public static List<int[]> allPairsWithGivenSum(Node head, int sum) {
        Node temp1=head;
        List<int[]> ds = new ArrayList<>();

        while(temp1!=null){
            Node temp2= temp1.next;
            while(temp2!=null && temp1.val+temp2.val<=sum){
                if(temp1.val+temp2.val==sum){
                    ds.add(new int[]{temp1.val, temp2.val});
                }
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        return ds;
    }

    //Optimal Solution[for sortedd DLL]
    public static List<int[]> allPairsWithGivenSum2(Node head, int sum){
        List<int[]> ans = new ArrayList<>();
        if(head==null) return ans;
        Node left=head;
        Node right=findTail(head);
        
        while(left != null && right != null && left.val<right.val){
            int currentSum = left.val + right.val;
            if(currentSum==sum){
                ans.add(new int[]{left.val, right.val});
                left=left.next;
                right=right.prev;
            }
            else if(currentSum<sum){
                left=left.next;
            }
            else{
                right=right.prev;
            }
        }
        return ans;
    }

    //OR
    // public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int sum, Node head) {
    //     ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    //     if (head == null) return ans;

    //     Node left = head;
    //     Node right = findTail(head);

    //     while (left != null && right != null && left.data < right.data) {
    //         int currentSum = left.data + right.data;
    //         if (currentSum == sum) {
    //             ArrayList<Integer> pair = new ArrayList<>();
    //             pair.add(left.data);
    //             pair.add(right.data);
    //             ans.add(pair);
    //             left = left.next;
    //             right = right.prev;
    //         } else if (currentSum < sum) {
    //             left = left.next;
    //         } else {
    //             right = right.prev;
    //         }
    //     }

    //     return ans;
    // }

    private static Node findTail(Node head){
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        return tail;
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
        //int[] arr = {4, 5, 3, 4, 10, 6};
        int[] arr = {1, 2, 3, 4, 9};

        Node head = convertArr2DLL(arr);
        System.out.println("Doubly Linked List Initially: ");
        print(head);
    
        int sum=5;
        //List<int[]> pairs = allPairsWithGivenSum(head, sum);
        List<int[]> pairs = allPairsWithGivenSum2(head, sum);
        for (int[] pair : pairs) {
            System.out.println("Pair: " + pair[0] + ", " + pair[1]);
        }

    }

    
}
