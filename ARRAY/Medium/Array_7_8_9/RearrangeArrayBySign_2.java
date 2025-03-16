package ARRAY.Medium.Array_7_8_9;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;

//VARIETY 2
public class RearrangeArrayBySign_2 {
    public static void main(String[] args) {
        // int n = 6;
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5, 3, 4));

        ArrayList<Integer> ans = RearrangebySign(A);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }

    public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A){
        int n=A.size();
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer>neg = new ArrayList<>();

        //Segregate the array into positives and negatives
        for(int i=0; i<n; i++){
            if (A.get(i) > 0)
                pos.add(A.get(i));
            else
                neg.add(A.get(i));
        }
        
        //If positives are lesser than negatives
        if(pos.size()<neg.size()){
            // First, fill array alternatively till the point 
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        //If negatives are lesser than positives
        if(neg.size()<pos.size()){
            // First, fill array alternatively till the point 
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }

}
