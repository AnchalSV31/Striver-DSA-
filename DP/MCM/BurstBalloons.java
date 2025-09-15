package DP.MCM;
import java.util.*;

public class BurstBalloons {
    //MEMOIZATION
    //TC:O(N^3) SC:O(N^2)+O(N)
    public static int maxCoins1(ArrayList<Integer> a){
        int n=a.size();
        a.add(1);
        a.add(0,1);
        int[][] dp= new int[n+2][n+2];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return maxCoins1(1,n,a,dp);
    }

    public static int maxCoins1(int i, int j, ArrayList<Integer> a, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxi= Integer.MIN_VALUE;
        for(int ind=i; ind<=j; ind++){
            int cost= a.get(i-1)*a.get(ind)*a.get(j+1)+maxCoins1(i, ind-1,a,dp)+ maxCoins1(ind+1, j, a, dp);
            maxi=Math.max(maxi, cost);
        }
        return dp[i][j]=maxi;
    }

    //TABULATION
    //TC:O(N^3) SC:O(N^2)
    public static int maxCoins2(ArrayList<Integer> a){
        int n=a.size();
        a.add(1);
        a.add(0,1);
        int[][] dp= new int[n+2][n+2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int maxi = Integer.MIN_VALUE;
                
                // Iterate through possible indices to split the array
                for (int ind = i; ind <= j; ind++) {
                    int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1) +
                               dp[i][ind - 1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 1, 5, 8));
        int ans = maxCoins1(a);
        int ans2 = maxCoins2(a);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
