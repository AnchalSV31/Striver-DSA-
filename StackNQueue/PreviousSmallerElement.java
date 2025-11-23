package StackNQueue;

import java.util.Stack;

//previous smaller equal element
public class PreviousSmallerElement {
    public static int[] previousSmallerElement(int[] nums) {
        int n = nums.length;
        int pse[] = new int[n];
        Stack < Integer > st = new Stack < > ();
        for (int i = 0; i <=n-1; i++) {
            while (st.isEmpty() == false && st.peek() >= nums[i]) {
                st.pop();
            }

            pse[i]=st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return pse;
    }
    public static void main(String args[]) {
        //int arr[]={4,5,2,10,8};
        int arr[]={5, 7, 9, 6, 7, 4, 5, 1, 3, 7};

        int arr2[] = previousSmallerElement(arr);
        System.out.println("The previous smaller elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
