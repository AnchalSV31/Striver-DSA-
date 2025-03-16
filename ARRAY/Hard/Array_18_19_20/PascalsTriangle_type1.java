package ARRAY.Hard.Array_18_19_20;

public class PascalsTriangle_type1 {
    public static void main(String[] args) {
        int r=5;
        int c=3;
        int element = pascalTriangle(r, c);
        System.out.println("Th element at position (r,c) is: "+ element);
    }

    //TYPE 1
    //GIVEN THE ROW NUMBER R AND COLUMN NUMBER C, PRINT THE ELEMENT AT POSITION(R,C) 

    //optimal
    
    public static long nCr(int n, int r){
        long res=1;

        //calculation nCr
        for(int i=0; i<r; i++){
            res= res*(n-i);
            res=res/(i+1);
        }
        return res;
    }

    public static int pascalTriangle(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }
}
