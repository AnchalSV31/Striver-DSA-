package SlidingWindow;

//Window size=3 of alternating groups
public class NumberOfAlternatingGroups {
    public static int numOfAltGroups(int[] arr){
        int n=arr.length;
        int count=0;

        for(int i=0; i<n; i++){
            int left=arr[i];
            int mid=arr[(i+1)%n];
            int right=arr[(i+2)%n];

            if(left!=mid && left==right){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr= {0,1,0,0,1};
        System.out.println(numOfAltGroups(arr));
    }
}
