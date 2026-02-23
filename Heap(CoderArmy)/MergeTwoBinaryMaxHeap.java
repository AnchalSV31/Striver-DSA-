package Heap;

public class MergeTwoBinaryMaxHeap {
    //TC:O(n + m)  SC:O(n + m)
    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        int size= n+m;
        int[] c= new int[size];
        
        //merge array
        int k=0;
        
        for(int i=0; i<n; i++){
            c[k++]=a[i];
        }
        
        for(int i=0; i<m; i++){
            c[k++]=b[i];
        }
        
        //build max heap
        for(int i=size/2 - 1; i>=0; i--){
            heapify(c, size, i);
        }
        return c;
    }
    
    public static void heapify(int[] c, int n, int i){
        int largest=i;
        int left= 2*i + 1;
        int right= 2*i + 2;
        
        if(left<n && c[left]>c[largest]){
            largest=left;
        }
        if(right<n && c[right]>c[largest]){
            largest=right;
        }
        if(largest!=i){
            int temp=c[i];
            c[i]=c[largest];
            c[largest]=temp;
            
            heapify(c,n,largest);
        }
    } 

    public static void main(String[] args) {
        int a[] = {10, 5, 6, 2}; 
        int b[] = {12, 7, 9};
        int n = a.length;
        int m = b.length;
        int c[] = mergeHeaps(a, b, n, m);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }
}
