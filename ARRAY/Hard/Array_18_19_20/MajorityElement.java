package ARRAY.Hard.Array_18_19_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        //List<Integer> ans = majorityElement(arr);
        //List<Integer> ans = majorityElement2(arr);
        List<Integer> ans = majorityElement3(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    //Find the elements that appears more than N/3 times in the array
    //Brute Force

    public static List<Integer> majorityElement(int nums[]){
        int n=nums.length;
        List<Integer> ls = new ArrayList<>();

        for(int i=0; i<n; i++){
           //selected element is v[i]:
            // Checking if nums[i] is not already
            // a part of the answer: 
            if(ls.size()==0 || ls.get(0)!=nums[i]){
                int cnt=0;
                for(int j=0; j<n; j++){
                    if(nums[j]==nums[i]){
                        cnt++;
                    }
                }

                //check if frequency is greater than n/3:
                if(cnt>(n/3)){
                    ls.add(nums[i]);
                }
            }
            if(ls.size()==2) break;
        }
        return ls;
    }

    //Better approach [Hashing]
    public static List<Integer> majorityElement2(int nums[]){
        int n=nums.length;
        List<Integer> ls = new ArrayList<>();

        HashMap<Integer, Integer> mpp = new HashMap<>();
        //least occurence of the majority element:
        int mini=(int)(n/3)+1;

        //storing the elements with its occurence:
        for(int i=0; i<n; i++){
            int value=mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], value+1);

            //checking if v[i] is
            // the majority element:
            if(mpp.get(nums[i])==mini){
                ls.add(nums[i]);
            }
            if(ls.size()==2) break;
        }
        return ls;
    }

    

    //Optimal Approach [Extended Boyer Moore’s Voting Algorithm]
    public static List<Integer> majorityElement3(int []nums){
        int n = nums.length; 

        int cnt1 = 0, cnt2 = 0; 
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i];
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i];
            } else if (nums[i] == el1) cnt1++;
            else if (nums[i] == el2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>();  //list of answers

        // Manually check if the stored elements in el1 and el2 are the majority elements:
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++;
            if (nums[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls);             //TC --> O(2*log2) ~ O(1);

        return ls;
    }
}
