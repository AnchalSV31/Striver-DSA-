package ARRAY.Hard.Array_18_19_20;

public class PascalsTriangle_type2 {
    public static void main(String[] args) {
        int n=5;
        //pascalTriangle(n);
        pascalTriangle2(n);
    }

    //Type 2
    //Given the row number n. Print the n-th row of Pascal’s triangle.

    //Brute force
    public static long nCr(int n, int r){
        long res=1;

        //calculation nCr
        for(int i=0; i<r; i++){
            res= res*(n-i);
            res=res/(i+1);
        }
        return res;
    }

    public static void pascalTriangle(int n){
        //printing the entire row n:
        for(int c=1; c<=n; c++){
            System.out.print(nCr(n-1, c-1)+ " ");
        }
        System.out.println();
    }


    //Optimal approach
    static void pascalTriangle2(int n){
        long ans=1;
        System.out.print(ans + " "); //printing 1st element

        //printing the rest of the part
        for(int i=1; i<n; i++){
            ans=ans*(n-i);
            ans=ans/i;
            System.out.print(ans+" ");
        }
        System.out.println();
    }
}
