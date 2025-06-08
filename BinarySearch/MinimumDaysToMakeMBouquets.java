package BinarySearch;

public class MinimumDaysToMakeMBouquets {
    public static int minDays(int[] arr, int m, int k) {
        long val = (long) m * k;
        int n = arr.length;
        if (val > n) return -1; // Impossible case.
    
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        int low =mini;
        int high=maxi;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(arr,mid,m,k)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    public static boolean isPossible(int[] arr, int day, int m, int k){
        int cnt=0;
        int noOfBouquet=0;

        for(int i=0; i<arr.length; i++){
            if(arr[i]<=day){
                cnt++;
            }
            else{
                noOfBouquet+=(cnt/k);
                cnt=0;
            }
        }
        noOfBouquet += (cnt / k);
        if(noOfBouquet>=m) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] bloomDay ={1,10,3,10,2};
        int m=3;
        int k=1;
        System.out.println(minDays(bloomDay,m,k));
    }
}
