package StackNQueue;

public class TrappingWater {
    //Brute Force
    public static int trap(int[] arr){
        int n=arr.length;
        int waterTrapped = 0;
        for(int i=0; i<n; i++){
            int j=i;
            int leftMax=0, rightMax=0;
            while(j>=0){
                leftMax=Math.max(leftMax, arr[j]);
                j--;
            }
            j=i;
            while(j<n){
                rightMax=Math.max(rightMax, arr[j]);
                j++;           
            }
            waterTrapped+=Math.min(leftMax, rightMax)-arr[i];
        }
        return waterTrapped;
    }

    //Better Solution
    public static int trap2(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return waterTrapped;
    }

    //Optimal solution[two pointer approach]
    public static int trap3(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap3(arr));
    }
}
