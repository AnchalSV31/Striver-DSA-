package BinarySearch;

public class LeastCapacityToShipPackagesWithinDDays {
    public static int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=Integer.MIN_VALUE;
        int high=0;

        for(int i=0; i<n; i++){
            high+=weights[i];
            low=Math.max(low,weights[i]);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int daysReq=findDays(weights,mid);
            if(daysReq<=days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    public static int findDays(int[] arr, int capacity){
        int n=arr.length;
        int daysReq=1;
        int load=0;

        for(int i=0; i<n; i++){
            if(load+arr[i]>capacity){
                daysReq++;
                load=arr[i];
            }else{
                load+=arr[i];
            }
        }
        return daysReq;
    }

    public static void main(String[] args) {
        int[] weights={1,2,3,4,5,6,7,8,9,10};
        int days=5;
        System.out.println(shipWithinDays(weights,days));
    }
}
