package SlidingWindow;

//number of subarray with sum==goal (here,2)
public class BinarySubarrayWithSum {
    //TC:O(2N)*2  SC:O(1)
    
    //to find subarray where sum<=goal
    public static int countSubarray(int[] arr, int k){
        int left=0, right=0;
        int n=arr.length;
        int sum=0;
        int count=0;
        
        if(k<0) return 0;

        while(right<n){
            sum+=arr[right];
            while(sum>k){
                sum-=arr[left];
                left++;
            }
            count+=(right-left+1);
            right++;
        }
    
        return count;
    }

    public static int count(int[] arr, int goal){
        return countSubarray(arr, goal)-countSubarray(arr, goal-1);
    }


    public static void main(String[] args) {
        int[] arr={1,0,1,0,1};
        int k=2;
        System.out.println(count(arr, k));
    }
}
