package DP;

public class HouseRobber2 {
    //TC:O(N) SC:O(1)
    public static long houseRobber2(int n, int[] arr){
        int[] arr1= new int[n];
        int[] arr2= new int[n];

        if(n==1) return arr[0];
        int idx1=0, idx2=0;
        for(int i=0; i<n; i++){
            if(i!=0) arr1[idx1++]=arr[i];    //first element not included
            if(i!=n-1) arr2[idx2++]=arr[i];    //last element not included
        }

        long ans1=solve(arr1);
        long ans2=solve(arr2);

        return Math.max(ans1, ans2);
    }

    public static long solve(int[] arr){
        int n=arr.length;
        long prev=arr[0];
        long prev2=0;

        for(int i=0; i<n; i++){
            long pick=arr[i];
            if(i>1) pick+=prev2;
            long nonpick=0+prev;

            long curr= Math.max(pick, nonpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    } 

    public static void main(String[] args) {
        int[] arr={1,5,1,2,6};
        int n=arr.length;
        System.out.println(houseRobber2(n, arr));
    }

}
