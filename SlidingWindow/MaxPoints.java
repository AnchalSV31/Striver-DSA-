package SlidingWindow;

//max points you can obtain from cards
public class MaxPoints {
    //TC:O(2*K) SC:O(1)
    public static int maxPoints(int[] card, int k){
        int n=card.length;
        int lSum=0;
        int rSum=0;
        int maxSum=0;

        for(int i=0; i<k; i++){
            lSum+=card[i];
        }
        maxSum=lSum;
    

        int rIndex=n-1;
        for(int i=k-1; i>=0; i--){
            lSum-=card[i];
            rSum+=card[rIndex];
            rIndex--;
            maxSum=Math.max(maxSum, lSum+rSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] card={6,2,3,4,7,2,1,7,1};
        int k=4;
        System.out.println(maxPoints(card, k));
    }
}
