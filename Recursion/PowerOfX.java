package Recursion;

public class PowerOfX {
    //BRUTE FORCE
    //TC: O(N) SC:O(1)
    public static double myPow(double x, int n){
        //base case: any number to the power of 0 is 1
        if(n==0 || x==1.0) return 1;

        long temp=n; //to avoid integer overflow

        //handle negative exponents
        if(n<0){
            x=1/x;
            temp= -1L*n;
        }

        double ans=1;

        for(long i=0; i<temp; i++){
            //multiply ans by x for n times
            ans*=x;
        }
        return ans;
    }

    //OPTIMAL SOLUTION
    //TC: O(log n) SC: O(log n)
    public static double myPow2(double x, int n){
        // If 'n' is negative, take reciprocal of positive exponent result
        long N=n;
        if(N<0){
            return 1.0/ power(x, -N);
        }
        // If 'n' is non-negative
        return power(x,N);
    }

    private static double power(double x, long n){
        // Base case: anything raised to 0 is 1
        if (n == 0) return 1.0;
        
        // Base case: anything raised to 1 is itself
        if (n == 1) return x;
        
        // If 'n' is even
        if (n % 2 == 0) {
            // Recursive call: square the base and halve the exponent
            return power(x * x, n / 2);
        }
        
        // If 'n' is odd
        // Recursive call: multiply base once and reduce exponent by 1
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.printf("%.4f\n", myPow(2.0000, 10));
        // Output: 0.2500 
        System.out.printf("%.4f\n", myPow(2.0000, -2));

        double x = 2.0;
        int n = 10;

        // Calculate power
        double result = myPow2(x, n);

        // Print result
        System.out.println(x + "^" + n + " = " + result);
    }
}
