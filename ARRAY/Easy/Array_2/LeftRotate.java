package ARRAY.Easy.Array_2;

public class LeftRotate {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n=7;
        int d=3;
        //leftRotateOne(arr, n);
        //leftRotate(arr, n, d);
        leftRotate2(arr, n, d);
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    //LEFT ROTATE BY ONE PLACE
    static void leftRotateOne(int arr[], int n){
        int temp= arr[0];
        for(int i=1; i<n; i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=temp;

    }
    //Left rotate by d places
    static void leftRotate(int arr[], int n, int d){
        d=d%n;
        if(d>n){
            return;
        }
        int temp[]= new int[d];
        //storing first d elements od array arr[] into temp[] array
        for(int i=0; i<d; i++){
            temp[i]=arr[i];
        }

        for(int i=d; i<n; i++){
            arr[i-d]= arr[i];
        }
        for(int i=n-d; i<n; i++){
            arr[i]=temp[i-(n-d)];
        }
        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i] + " ");
        // }
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
    static void leftRotate2(int arr[], int n, int d){
        d=d%n;
        reverse(arr, 0, d-1);  //0 to d
        reverse(arr, n-d, n-1);        //d to n
        reverse(arr, 0, n-1);    //0 to n
    }
}
