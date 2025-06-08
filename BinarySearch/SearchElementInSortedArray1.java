package BinarySearch;

//Search element in rotated sorted array
public class SearchElementInSortedArray1 {
    //No duplicates
    public static int search1(int[] arr, int k){
        int n=arr.length;
        int low=0, high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==k) return mid;

            if(arr[mid]>=arr[low]){
                if(arr[low]<=k && k<=arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(arr[mid]<=k && k<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }


    //Duplicates
    public static boolean search2(int[] arr, int k){
        int n=arr.length;
        int low=0, high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==k) return true;

            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }

            if(arr[low]<=arr[mid]){
                if(arr[low]<=k && k<=arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            else{
                if(arr[mid]<=k && k<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        int k=0;
        System.out.println(search1(arr,k));

        int[] arr2={2,5,6,0,0,1,2};
        int k2=0;
        System.out.println(search2(arr2,k2));
    }
}
