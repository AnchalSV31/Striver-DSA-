package ARRAY.Hard.Array_27_28;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
		//int answer = maxProductSubarray(nums);
        //int answer = maxProductSubarray2(nums);
        int answer = maxProductSubarray3(nums);
		System.out.print("The maximum product subarray is: "+answer);
    }

    //Brute Force
    public static int maxProductSubarray(int arr[]){
        int n=arr.length;
        int result = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int prod=1;
                for(int k=i;k<=j;k++){
                    prod=prod*arr[k];
                }
                result=Math.max(result, prod);
            }
        }
        return result;
    }

    //Better approach
    static int maxProductSubarray2(int arr[]) {
	    int result = arr[0];
	    for(int i=0;i<arr.length-1;i++) {
	        int p = arr[i];
	        for(int j=i+1;j<arr.length;j++) {
	            result = Math.max(result,p);
	            p *= arr[j];
	        }
	        result = Math.max(result,p);
	    }
	   return result;     
	}

    //Optimal Approach
    public static int maxProductSubarray3(int[] arr) {
        int n = arr.length; //size of array.

        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }

    
}
