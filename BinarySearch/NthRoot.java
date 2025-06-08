package BinarySearch;

public class NthRoot {
    public static int nthRoot(int n, int m){
        int l=1, r=m;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(func(mid,n,m)==1){
                return mid;
            }
            else if(func(mid,n,m)==0){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }

     //Return 1 if mid == m
    //Return 0 if mid < m
    //Return 2 if mid > m
    public static int func(int mid, int n, int m){
        long ans=1;
        for(int i=1; i<=n; i++){
            ans=ans*mid;
            if(ans>m) return 2;
        }
        if(ans==m) return 1;
        return 0;
    }

    public static void main(String[] args) {
        int n=3;
        int m=27;
        System.out.println(nthRoot(n,m));
    }
}
