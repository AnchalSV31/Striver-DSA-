package SlidingWindow;

public class GrumpyBookstore {
    public static int maxSatisfies(int[] customers, int[] grumpy, int min){
        int n=customers.length;
        int satisfied=0;

        for(int i=0; i<n; i++){
            if(grumpy[i]==0){
                satisfied+=customers[i];
            }
        }

        int extra=0;
        for(int i=0; i<min; i++){
            if(grumpy[i]==1){
                extra+=customers[i];
            }
        }

        int maxExtra=extra;
        for(int i=min; i<n; i++){
            if(grumpy[i]==1){
                extra+=customers[i];
            }
            if(grumpy[i-min]==1){
                extra-=customers[i-min];
            }
            maxExtra=Math.max(extra, maxExtra);
        }
        return satisfied+maxExtra;
    }

    public static void main(String[] args) {
        int[] customers={1,0,1,2,1,1,7,5};
        int[] grumpy={0,1,0,1,0,1,0,1};
        int min=3;
        System.out.println(maxSatisfies(customers, grumpy, min));
    }
}
