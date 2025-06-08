package BinarySearch;

public class FirstAndLastOccurences {
    //Method 1

    //TC: O(2 logn) SC: O(1)
    public static int[] firstAndLast1(int[] arr, int x){
        if (arr == null || arr.length == 0) return new int[]{-1, -1};

        int l = lower(arr, x);
        int u = upper(arr, x);

        // If x is not present
        if (l == arr.length || arr[l] != x) return new int[]{-1, -1};

        return new int[]{l, u - 1};
    }

    public static int lower(int[] arr, int k){
        int n=arr.length;
        int low=0, high=n-1;
        int ans=n;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static int upper(int[] arr, int k){
        int n=arr.length;
        int low=0, high=n-1;
        int ans=n;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    //Method 2

    //TC:O(LOG N) SC:O(1)
    public static int[] firstAndLast2(int[] arr, int x){
        if (arr == null || arr.length == 0) return new int[]{-1, -1};

        int f = first(arr, x);
        if(f==-1) return new int[]{-1,-1};

        int l = last(arr, x);
        return new int[]{f,l};
    }

    public static int first(int[] arr, int x){
        int n=arr.length;
        int low=0, high=n-1;
        int first=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x){
                first=mid;
                high=mid-1;
            }else if(arr[mid]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return first;
    }

    public static int last(int[] arr, int x){
        int n=arr.length;
        int low=0, high=n-1;
        int last=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x){
                last=mid;
                low=mid+1;
            }else if(arr[mid]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] arr={2,4,6,8,8,8,11,13};
        int x=8;
        // int[] ans = firstAndLast1(arr,x);
        int[] ans = firstAndLast2(arr,x);
        System.out.println(ans[0]+" "+ans[1]);

        
    }

}
