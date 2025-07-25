package ARRAY.Hard.Array_18_19_20;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_type3{
    public static void main(String[] args) {
        int n = 5;
        //List<List<Integer>> ans = pascalTriangle(n);
        List<List<Integer>> ans2 = pascalTriangle2(n);
        for (List<Integer> it : ans2) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    //Type 3
    //For given row number, print the entire pascals triangle

    //Brute force
    public static int nCr(int n, int r) {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entire Pascal's triangle:
        for (int row = 1; row <= n; row++) {
            List<Integer> tempLst = new ArrayList<>(); // temporary list
            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }


    //Optimal approach
    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); //inserting the 1st element

        //calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> pascalTriangle2(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        //store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }

}