package DP.LIS;

import java.util.*;

//TC:O(N*N*L) SC:O(N)
public class LongestStringChain{
    // Custom comparison function for sorting strings by length
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    public static int longestStrChain(List<String> arr){
        int n=arr.size();

        arr.sort(comp);  //sort the array by string length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi=1;

        for(int i=0; i<n; i++){
            for(int prev_ind=0; prev_ind<i; prev_ind++){
                if(compare(arr.get(i), arr.get(prev_ind)) && 1+dp[prev_ind]>dp[i]){
                    dp[i]=1+dp[prev_ind];
                }
            }
            if(dp[i]>maxi){
                maxi= dp[i];
            }
        }
        return maxi;
    }

    public static boolean compare(String s1, String s2){
        if(s1.length()!=s2.length()+1) return false;

        int first=0;
        int second=0;

        while(first<s1.length()){
            if(second<s2.length() && s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        return first==s1.length() && second==s2.length();
    }

    //TC:O(N*L*L) SC:O(n + L) 
    public static int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length)); // sort by length

        Map<String, Integer> dp = new HashMap<>();
        int maxi = 1;

        for (String word : words) {
            int best = 1; // at least the word itself
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1); // remove one char
                best = Math.max(best, dp.getOrDefault(predecessor, 0) + 1);
            }
            dp.put(word, best);
            maxi = Math.max(maxi, best);
        }
        return maxi;
    }

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("a", "b", "ba", "bca", "bda", "bdca");
        String arr2[]={"a","b","ba","bca","bda","bdca"};

        int ans = longestStrChain(arr);
        System.out.println(ans);

        int ans2=longestStrChain(arr2);
        System.out.println(ans2);
    
    }
}