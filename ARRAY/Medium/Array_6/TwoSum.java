package ARRAY.Medium.Array_6;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        //String ans = twoSum(n, arr, target);
        //System.out.println("Is two sum possible: " + ans);

        // int[] ansIndex = twoSumIndex(n, arr, target);
        // System.out.println("Two sum is possible at index: [" + ansIndex[0] + ", "
        //                    + ansIndex[1] + "]");

        //String ans2 = twoSum2(n, arr, target);
        //System.out.println("Is two sum possible: " + ans2);

        //index
        //int[] ans2 = twoSum2(n, arr, target);
        //System.out.println("Two sum is possible at index: ["+ ans2[0]+","+ans2[1]+"]");

        String ans3 = twoSum3(n, arr, target);
        System.out.println("Is two sum possible: " + ans3);
    }

    //Brute force
    public static String twoSum(int n, int []arr, int target){
        for(int i=0; i<n; i++){
            for(int j=1; j<n; j++){
                if(arr[i]+arr[j]==target){
                    return "YES";
                }              
            }
        }
        return "NO";
    }

    //BRUTE FORCE(PRINT INDEXES)
    public static int[] twoSumIndex(int n, int []arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    //Better approach (HASHING)
    public static int[] twoSum2(int n, int arr[], int target){    //replace int[] with string is you only want to print possibility and not indexes
        int[] ans= new int[2]; //index que
        ans[0]=ans[1]=-1;      //index que
        HashMap<Integer, Integer> mpp=new HashMap<>();
        for(int i=0; i<n; i++){
            int num=arr[i];
            int moreNeeded=target-num;
            if(mpp.containsKey(moreNeeded)){
                //return "YES";

                //if index is also asked then:
                ans[0] = mpp.get(moreNeeded);
                ans[1] = i;
                return ans;
            }
            mpp.put(arr[i], i);
        }
        //return "NO";

        //index:
        return ans;
    }

    //OPTIMAL APPROACH (2 pointer)
    public static String twoSum3(int n, int []arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return "YES";
            }
            else if (sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return "NO";
    }

}
