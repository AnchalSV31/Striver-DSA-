package Recursion;

//TC: O(2^n) SC: O(N)
public class CountGoodNumbers{
    static final int MOD = 1000000007;
    public static int countGoodNumbers(int index, int n){
        //base case: if we have reached the end of the string
        if(index==n){
            return 1;
        } 

        int result=0;
        //even index: use even digits
        if(index%2 == 0){
            //even digits: 0,2,4,6,8
            int[] evenDigits = {0, 2, 4, 6, 8};
            for (int digit : evenDigits) {
                result=(result+ countGoodNumbers(index+1, n))%MOD;
            }
        }

        //odd index: use prime digits
        else{
            //prime digits: 2,3,5,7
            int[] primeDigits = {2, 3, 5, 7};
            for (int digit : primeDigits) {
                result = (result + countGoodNumbers(index + 1, n)) % MOD;
            }
        }
        return result;
    }

    //optimized
    //TC: O(log n) SC:O(log n)
    // answer = (5^(ceil(n/2)) × 4^(floor(n/2))) % MOD
    public static int countGoodNumbers2(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenWays = modPow(5, evenPositions);
        long oddWays = modPow(4, oddPositions);

        return (int)((evenWays * oddWays) % MOD);
    }

    static final long mod = 1000000007;

    public static long modPow(long base, long exp) {
        // Base case
        if (exp == 0) {
            return 1;
        }

        // Recursive call
        long half = modPow(base, exp / 2);

        // If exponent is even
        if (exp % 2 == 0) {
            return (half * half) % mod;
        }
        // If exponent is odd
        else {
            return (half * half % MOD * base) % mod;
        }
    }

    public static void main(String[] args) {
        int n=2;
        Long n2=4L;
        System.out.println(countGoodNumbers(0,n));
        System.out.println(countGoodNumbers2(n2));
    }
}