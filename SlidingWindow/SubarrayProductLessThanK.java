package SlidingWindow;

public class SubarrayProductLessThanK {
    public static int subarrayProduct(int[] arr, int k){
        int n=arr.length;
        int l=0, count=0;
        int prod=1;

        for(int r=0; r<n; r++){
            prod*=arr[r];

            while(prod>=k && l<=r){
                prod/=arr[l];
                l++;
            }
            count+=(r-l+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr={10,5,2,6};
        int k=100;
        System.out.println(subarrayProduct(arr, k));
    }
}
