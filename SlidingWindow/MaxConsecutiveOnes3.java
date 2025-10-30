package SlidingWindow;

//longest subarray with atmost k zeros
public class MaxConsecutiveOnes3 {
    //TC:O(N^2) SC:O(1)
    public static int longestOnes(int[] arr, int k){
        int n=arr.length;
        int maxLength=0;

        for(int i=0; i<n; i++){
            int zeros=0;
            for(int j=i; j<n; j++){
                if(arr[j]==0){
                    zeros++;
                }
                if(zeros<=k){
                    maxLength=Math.max(maxLength, j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxLength;
    }

    //TC:O(2N)[nested while loops] SC:O(1)
    public static int longestOnes2(int[] arr, int k){
        int n=arr.length;
        int left=0, right=0;
        int maxLength=0;
        int zeros=0;

        while(right<n){
            if(arr[right]==0){
                zeros++;
            }
            while(zeros>k){
                if(arr[left]==0){
                    zeros--;
                }
                left++;
            }
            maxLength=Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }

    //TC:O(N) SC:O(1)
    public static int longestOnes3(int[] arr, int k){
        int n=arr.length;
        int left=0, right=0;
        int maxLength=0;
        int zeros=0;

        while(right<n){
            if(arr[right]==0){
                zeros++;
            }
            if(zeros>k){
                if(arr[left]==0) zeros--;
                left++;
            }
            if(zeros<=k){
                maxLength=Math.max(maxLength, right-left+1);
            }
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(arr, k));
        System.out.println(longestOnes2(arr, k));
        System.out.println(longestOnes3(arr, k));
    }
}
