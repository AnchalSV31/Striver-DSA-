package BinarySearch;

public class CountOccurences {
    public static int count(int[] arr, int x){
        if (arr == null || arr.length == 0) return 0;
        int f = first(arr, x);
        if(f==-1) return 0;
        int l = last(arr, x);
        return l-f+1;
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
        System.out.print(count(arr,x));
    }
}
