package ARRAY.Easy.Array_1;
public class Sorted {
    public static void main(String[] args) {
        int arr[]= {1, 2, 3, 4, 5};
        int arr1[]={5,4,3,2,1};
        System.out.println(isSortedDesc(arr1));
        System.out.println(isSortedAsc(arr));
    }

    //optimal approach in both the cases
    //descending
    static boolean isSortedDesc(int arr[]){
        for(int i=0; i<arr.length; i++){
            if(arr[i]<arr[i+1]){
                return false;
            }
            return true;
        }
        return true;
    }

    //ascending
    static boolean isSortedAsc(int arr[]){
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=arr[i+1]){
                return true;
            }
            return false;
        }
        return true;
    }
}
