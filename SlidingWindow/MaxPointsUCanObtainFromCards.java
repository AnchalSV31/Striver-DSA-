package SlidingWindow;

public class MaxPointsUCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        // code here.
        int n = cardPoints.length;

        int l = 0;
        int r = n - 1;

        int currSum = 0;

        // take first k cards from left
        while (l < k) {
            currSum += cardPoints[l];
            l++;
        }

        int maxSum = currSum;

        // now replace left cards with right cards
        l = k - 1;  // last taken from left

        while (l >= 0) {
            currSum -= cardPoints[l]; // remove left
            currSum += cardPoints[r]; // add right
            r--;

            maxSum = Math.max(maxSum, currSum);
            l--;
        }

        return maxSum;
    }

    public static int maxScore2(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int totalSum = 0;
        for (int num : cardPoints) totalSum += num;

        // If we take all cards
        if (k == n) return totalSum;

        int windowSize = n - k;
        int windowSum = 0;

        // First window
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minWindowSum = windowSum;

        // Sliding window
        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        return totalSum - minWindowSum;
    }


    public static void main(String[] args) {
        int cardPoints[] = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
        System.out.println(maxScore2(cardPoints, k));
    }
}
