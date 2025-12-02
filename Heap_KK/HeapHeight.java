package Heap_KK;

public class HeapHeight {
    //TC: O(log n)
    public static int heapHeight(int[] arr){
        int n=arr.length;

        if(n==1) return 1;

        int height=0;

        while(n>1){
            height++;
            n /= 2;
        }
        return height;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(heapHeight(arr));
    }
}
