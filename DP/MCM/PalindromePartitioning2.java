package DP.MCM;
import java.util.*;

public class PalindromePartitioning2 {
    //MEMOIZATION
    //TC:O(N^2)  SC:O(N)+O(N)
    public static int palindromePartition1(String str){
        int n=str.length();
        int dp[]= new int[n];
        Arrays.fill(dp, -1);
        return f(0, n, str, dp)-1;
    }

    public static int f(int i, int n, String str, int[] dp){
        if(i==n) return 0;

        if(dp[i]!=-1) return dp[i];
        int minCost= Integer.MAX_VALUE;

        for(int j=i; j<n; j++){
            if(isPalindrome(i, j, str)){
                int cost=1+f(j+1, n, str, dp);
                minCost=Math.min(minCost, cost);
            }
        }
        return dp[i]=minCost;
    }

    public static boolean isPalindrome(int i, int j, String str){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    //TABULATION
    //TC:O(N^2) SC:O(N)
    static int palindromePartition2(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            // String[i...j]
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, str)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
    }

    public static void main(String[] args) {
        String str = "BABABCBADCEDE";
        int partitions = palindromePartition1(str);
        int partitions2 = palindromePartition2(str);
        System.out.println(partitions);
        System.out.println(partitions2);
    }
}
