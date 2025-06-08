package BinarySearch;

// import java.util.Arrays;

public class KokoEatingBananas {
    public static int kokoEating(int[] arr, int h){
        int low=1;
        // int high=Arrays.stream(arr).max().getAsInt();
        int high=findMax(arr);

        while(low<=high){
            int mid=low+(high-low)/2;
            int totalHrs=hours(arr,mid);
            if(totalHrs<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    public static int hours(int[] arr, int maxHr){
        int n=arr.length;
        int totalHrs=0;

        for(int i=0; i<n; i++){
            totalHrs+=Math.ceil((double)arr[i]/maxHr);
        }
        return totalHrs;
    }

    public static int findMax(int[] arr) {
        int maxi = Integer.MIN_VALUE;;
        int n = arr.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr={3,6,7,11};
        int h=8;
        System.out.println(kokoEating(arr,h));
    }
}
