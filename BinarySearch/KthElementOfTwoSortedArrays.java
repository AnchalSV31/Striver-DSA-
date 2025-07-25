package BinarySearch;

public class KthElementOfTwoSortedArrays {
    public static double kthElement(int[] arr1, int[] arr2, int k) {
        int n1=arr1.length;
        int n2=arr2.length;
        if(n1>n2) return kthElement(arr2, arr1, k);
        int low=Math.max(k-n2,0), high=Math.min(k,n1);

        int left=k;
        // int n=n1+n2;

        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            
            if(mid1<n1) r1=arr1[mid1];
            if(mid2<n2) r2=arr2[mid2];
            if(mid1>0) l1=arr1[mid1-1];
            if(mid2>0) l2=arr2[mid2-1];

            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] arr1={2,3,45};
        int[] arr2={4,6,7,8};
        int k=4;
        System.out.println(kthElement(arr1,arr2,k));
    }
}
