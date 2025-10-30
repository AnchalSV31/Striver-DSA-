package Greedy;
import java.util.*;

public class AssignCookies {
    //MEMOIZATION
    //TC: O(n*m) SC: O(n*m)+ O(n+m)
    public static int findContentChildren(int[] student, int[] cookie){
        Arrays.sort(student);
        Arrays.sort(cookie);

        int[][] memo = new int[student.length][cookie.length];
        
        return helper(0, 0, student, cookie, memo);
    }

    public static int helper(int studentIndex, int cookieIndex, int[] student, int[] cookie, int[][] memo){
        // Base case: if we reach end of either list
        if(studentIndex>=student.length || cookieIndex>=cookie.length){
            return 0;
        }

        if(memo[studentIndex][cookieIndex]!=0){
            return memo[studentIndex][cookieIndex];
        }

        int result=0;

        // If the cookie satisfies the student's greed
        if(cookie[cookieIndex]>=student[studentIndex]){
            // Option 1: assign this cookie and move to next student and cookie
            result=Math.max(result, 1+helper(studentIndex+1, cookieIndex+1, student, cookie, memo));
        }

        // Option 2: skip this cookie and try the next one for the same student
        result=Math.max(result, helper(studentIndex, cookieIndex + 1, student, cookie, memo));

        return memo[studentIndex][cookieIndex]=result;
    }

    //TABULATION
    //TC: O(n*m) SC: O(n*m)
    public static int findContentChildren2(int[] student, int[] cookie){
        int n = student.length;
        int m = cookie.length;

        Arrays.sort(student);
        Arrays.sort(cookie);

        int[][] dp = new int[n+1][m+1];

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                int skip=dp[i][j+1];
                int take=0;
                if(cookie[j]>=student[i]){
                    take=1+dp[i+1][j+1];
                }
                dp[i][j]=Math.max(skip, take);
            }
        }
        return dp[0][0];
    }

    //OPTIMAL APPROACH
    //TC:O(n*logn + m*logm) SC:O(1)
    public static int findContentChildren3(int[] student, int[] cookie){
        Arrays.sort(student);
        Arrays.sort(cookie);

        int studentIndex=0;
        int cookieIndex=0;

        while(studentIndex<student.length && cookieIndex<cookie.length){
            if(cookie[cookieIndex]>=student[studentIndex]){
                studentIndex++;
            }
            cookieIndex++;
        }
        return studentIndex;
    } 

    public static void main(String[] args) {
        int[] student = {1, 2, 3};
        int[] cookie = {1, 1};

        // int result= findContentChildren(student, cookie);
        // int result= findContentChildren2(student, cookie);
        int result= findContentChildren3(student, cookie);
        System.out.println(result);
    }
}
