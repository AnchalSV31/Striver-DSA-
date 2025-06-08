package BinarySearch;

public class Sqrt{
    public static int sqrt(int x){
        if(x==0 || x==1) return x;

        int l=1, r=x;
        int ans=-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid<=x/mid){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x=8;
        System.out.println(sqrt(x));
    }
}