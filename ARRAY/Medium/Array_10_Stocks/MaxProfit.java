package ARRAY.Medium.Array_10_Stocks;

public class MaxProfit {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        //int maxPro = maxProfit(arr);
        int maxPro2 = maxProfit2(arr);
        System.out.println("Max profit is: " + maxPro2);
    }
    
    //Stock Buy And Sell
    //Brute force
    static int maxProfit(int arr[]){
        int n= arr.length;
        int maxP=0;  //MAX profit
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[j]>arr[i]){
                    maxP=Math.max(arr[j]-arr[i], maxP);
                }
            }
        }
        return maxP;
    }

    //Optimal approach
    static int maxProfit2(int arr[]){
        int n=arr.length;
        int maxP=0;
        int minPrice= Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            minPrice=Math.min(minPrice, arr[i]);
            maxP=Math.max(maxP, arr[i]-minPrice);
        }
        return maxP;
    }
}
