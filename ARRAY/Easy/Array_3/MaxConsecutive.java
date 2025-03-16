package ARRAY.Easy.Array_3;

public class MaxConsecutive {
    public static void main(String[] args) {
        int a[] = {1,1,0,1,1,0,1,1,1,1,0,1};
        int ans= maxCons(a);
        System.out.println("Max consecutive ones:" + ans);
    }

    public static int maxCons(int a[]){
        int maxI=0;
        int count=0;
        for(int i=0; i<a.length; i++){
            if(a[i]==1){
                count++;
                maxI=(Math.max(maxI, count));
            }
            else{
                count=0;
            }
        }
        return maxI;
    }
    
}
