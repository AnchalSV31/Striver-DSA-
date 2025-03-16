package ARRAY.Easy.Array_2;

public class Intersection {
    public static void main(String[] args) {
        int A[] = {1,2,3,3,4,4,5,6};
        int B[] = {2,3,3,4,5,6,6,7,8};
        int n=8;
        int m=9;
        intersec1(A, B, n, m);
        //intersec(A, B, n, m);
    }
     
    //BRUTE FORCE
    static void intersec(int A[], int B[], int n, int m){
        int vis[]=new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(A[i]==B[j] && vis[j]==0){
                    System.out.print(A[i]+" ");
                    vis[j]=1;
                    break;
                }
                if(B[j]>A[i]){
                    break;
                }
            }
        }
    }

    //OPTIMAL
    static int intersec1(int A[], int B[], int n, int m){
        int i=0, j=0;
        while(i<n && j<m){
            if(A[i]<B[j]){
                i++;
            }
            else if(B[j]<A[i]){
                j++;
            }
            else{
                System.out.print(A[i]+" ");
                i++;
                j++;
            }
        }
        return 0;
    }
    
}
