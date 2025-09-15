package DP.LIS;
import java.util.*;

public class LongestDivisibleSubset {
    //TC: O(N*N) SC:O(N)
    public static List<Integer> divisibleSet(List<Integer> arr){
        int n=arr.size();

        Collections.sort(arr);

        List<Integer> dp= new ArrayList<>(Collections.nCopies(n,1));
        List<Integer> hash= new ArrayList<>(Collections.nCopies(n,0));

        for(int i=0; i<n; i++){
            hash.set(i, i); // initially pointing to itself
            for(int prev_ind=0; prev_ind<=i-1; prev_ind++){
                if(arr.get(i)%arr.get(prev_ind)==0 && 1+dp.get(prev_ind)>dp.get(i)){
                    dp.set(i, 1+dp.get(prev_ind));
                    hash.set(i, prev_ind);
                }
            }
        }

        //find max length
        int ans=-1;
        int lastIndex=-1;

        for(int i=0; i<n; i++){
            if(dp.get(i)>ans){
                ans= dp.get(i);
                lastIndex=i;
            }
        }

        //reconstruct subset
        List<Integer> temp= new ArrayList<>();
        temp.add(arr.get(lastIndex));

        while(hash.get(lastIndex)!=lastIndex){
            lastIndex=hash.get(lastIndex);
            temp.add(arr.get(lastIndex));
        }
        Collections.reverse(temp);

        return temp;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 16, 7, 8, 4);
        List<Integer> ans = divisibleSet(arr);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
