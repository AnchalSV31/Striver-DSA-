package StackNQueue;

public class CelebrityProblem {
    //celebrity = everyone knows him, he knows no one
    public static int findCelebrity(int[][] arr) {
        int[] knowMe = new int[arr.length];
        int[] iKnow = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i][j]==1){
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            if(iKnow[i]==0 && knowMe[i]==arr.length-1){
                return i;
            }
        }
        return -1;
    }


    //Optimal Solution
    public static int findCelebrity2(int[][] arr) {
        int n=arr.length;
        int top=0, down = n-1;
        while(top<down){
            if(arr[top][down]==1){
                top++;
            }
            else{
                down--;
            }
        }
        if(top>down) return -1;
        for(int i=0; i<n; i++){
            if(i!=top && (arr[top][i]==1 || arr[i][top]==0)){
                return -1;
            }
        }
        return top;
    }

    public static void main(String[] args) {
        // int[][] arr={{0,1,1,0},{0,0,1,0},{0,0,0,0},{0,1,1,0}};
        int[][] arr={{0,1,1,0},{0,0,0,0},{0,1,0,0},{0,1,0,0}};
        System.out.println(findCelebrity2(arr));
    }

}
