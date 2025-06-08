package LINKEDLIST.MediumProblemsOfLL;

import java.util.HashSet;

public class PairSum {
    //check if there exists a pair of nodes whose values sum up to a given target
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    //BRUTE FORCE
    //TC:O(N^2) SC:O(1)
    public static boolean pairSum(ListNode head, int k) {
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            while (temp != null) {
                if (current.val + temp.val == k) {
                    return true; // Pair found
                }
                temp = temp.next;
            }
            current = current.next;
        }
        return false; // No pair found
    }

    //TC:O(N) SC:O(N) 
    public static boolean pairSum2(ListNode head, int k){
        HashSet<Integer> second= new HashSet<>();   

        while(head!=null){
            int complement=k-head.val;
            while(second.contains(complement)){
                return true;
            }
            second.add(head.val);
            head=head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(3);

        int target = 10;
        System.out.println(pairSum(head, target));
        System.out.println(pairSum2(head, target));
    }

}
