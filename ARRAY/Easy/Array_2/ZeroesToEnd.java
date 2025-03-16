package ARRAY.Easy.Array_2;
// import java.util.*;
import java.util.ArrayList;

public class ZeroesToEnd{
    public static void main(String[] args) {
        int arr[]={1,0,2,3,0,0,4,5,1};
        int n=9;
        //int ans[]= moveZeros(n, arr);
        int ans1[] = moveZeros1(n, arr);
        for(int i=0; i<n; i++){
            System.out.print(ans1[i]+ " ");
        }
        System.out.println();

    }

    //BRUTE FORCE
    public static int[] moveZeros(int n, int a[]){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(a[i]!=0){
                temp.add(a[i]);
            }
        }
        //non zero elements
        int nz= temp.size();

        //copy elements from temp and put them at first nz places of original array
        for(int i=0; i<nz; i++){
            a[i]=temp.get(i);
        }

        //fill rest of the cells with 0
        for(int i=nz; i<n; i++){
            a[i]=0;
        }
        return a;   
    }

    //OPTIMAL APPROACH
    public static int[] moveZeros1(int n, int []a){
        int j=-1;
        for(int i=0; i<n; i++){
            if(a[i]==0){
                j=i;
                break;
            }
        }
        //no non zero elements
        if(j==-1){
            return a;
        }
        
        for(int i=j+1; i<n; i++){
            if(a[i]!=0){
                //swap
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                j++;
            }
        }
        return a;
    }
}