package ARRAY.Easy.Array_4_5;

public class SortArray {
    public static void main(String[] args) {
        int n = 6;
        int arr[]= {0, 2, 1, 2, 0, 1};
        //ArraySort(arr, n);
        ArraySort2(arr, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //Sort an array of 0s, 1s and 2s
    //Better solution
    public static void ArraySort(int arr[], int n){
        int count0=0, count1=0, count2=0;
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                count0++;
            }
            else if(arr[i]==1){
                count1++;
            }
            else{
                count2++;
            }
        }
        for(int i = 0; i < count0; i++){
            arr[i] = 0;
        }

        for (int i = count0; i < count0 + count1; i++){
            arr[i] = 1;
        }
        

        for (int i = count0 + count1; i < n; i++){
            arr[i] = 2;
        }   
    }


    //OPTIMAL APPROACH (Dutch National flag algorithm)[3 pointers]
    public static void ArraySort2(int arr[], int n){
        int low=0, mid=0, high=n-1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]= arr[mid];
                arr[mid]=temp;

                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                int temp=arr[mid];
                arr[mid]= arr[high];
                arr[high]=temp;

                high--;
            }
        }
    }
}
