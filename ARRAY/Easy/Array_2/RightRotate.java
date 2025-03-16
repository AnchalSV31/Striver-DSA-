package ARRAY.Easy.Array_2;

public class RightRotate {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n=7;
        int d=3;
        //righttRotateOne(arr, n);
        righttRotate2(arr, n, d);
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    //RIGHT ROTATE BY ONE PLACE
    static void righttRotateOne(int arr[], int n){
        int temp= arr[n-1];
        for(int i=n-1; i>0; i--){
            arr[i]=arr[i-1];
        }
        arr[0]=temp;

    }
    //optimal approach
    public static void reverse(int arr[], int start, int end){
        while(start<=end){
            int temp=arr[start];
            arr[start]= arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
    }
    static void righttRotate2(int arr[], int n, int d){
        d=d%n;
        reverse(arr, n-d, n-1);
        reverse(arr, 0, n-d-1);  //0 to d
        // reverse(arr, n-d, n-1);        //d to n
        reverse(arr, 0, n-1);    //0 to n
    }
    
}
