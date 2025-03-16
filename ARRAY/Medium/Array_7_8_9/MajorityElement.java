package ARRAY.Medium.Array_7_8_9;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        //int ans = majorityElement(arr);
        //int ans2 = majorityElement2(arr);
        int ans3 = majorityElement3(arr);
        System.out.println("The majority element is: " + ans3);

    }

    //MAJORITY ELEMENT [element that occurs more than N/2 times]

    //Brute Force
    public static int majorityElement(int []arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of arr[i]
                if (arr[j] == arr[i]) {
                    cnt++;
                }
            }
            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return arr[i];
        }
        return -1;
    }


    //Better Solution (HASHING)
    public static int majorityElement2(int arr[]){
        int n = arr.length;
      
        HashMap<Integer, Integer> mpp= new HashMap<>();
        //storing the elements with its occurnce:
        for(int i=0; i<n; i++){
           int value=mpp.getOrDefault(arr[i], 0);
           mpp.put(arr[i], value+1);
        }

        //searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }

    //Optimal Solution [MOORE'S VOTING ALGORITHM]
    public static int majorityElement3(int arr[]){
        int n=arr.length;
        int count=0;
        int el=0;
        for(int i=0; i<n; i++){
            if(count==0){
                count=1;
                el=arr[i];
            }
            else if(arr[i]==el){
                count++;
            }
            else{
                count--;
            }
        }

        //checking if the stored element is the majority element:
        int count1=0;
        for(int i=0; i<n; i++){
            if(arr[i]==el){
                count1++;
            }
        }
        if(count1>(n/2)){
            return el;
        }
        return -1;
    }
}
