package StackNQueue;

public class CelebrityProblem {
    //celebrity = everyone knows him, he knows no one
    //TC:O(N²) SC:O(N)
    public static int findCelebrity(int[][] arr) {
        int[] knowMe = new int[arr.length];
        int[] iKnow = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                // If person i knows person j
                if(arr[i][j]==1){
                    knowMe[j]++;  // Person j is known by person i
                    iKnow[i]++;   // Person i is known by person j
                }
            }
        }
        // Traverse all persons to find the celebrity
        for(int i=0; i<arr.length; i++){
            // If person i knows no one and is known by everyone else
            if(iKnow[i]==0 && knowMe[i]==arr.length-1){
                return i;   // Person i is the celebrity
            }
        }
        return -1;
    }


    //Optimal Solution
    //TC: O(N) SC:O(1)
    public static int findCelebrity2(int[][] arr) {
        int n=arr.length;
        // Top and Down pointers for narrowing the possible celebrity
        int top=0, down = n-1;
        // Traverse for all the people to find potential celebrity
        while(top<down){
            // If top knows down, top cannot be a celebrity
            if(arr[top][down]==1){
                top++;
            }
            // If down knows top, down cannot be a celebrity
            else if(arr[down][top]==1){
                down--;
            }
            // If neither knows each other, both are not the celebrity
            else{
                top++;
                down--;
            }
        }
        // If top exceeds down, no celebrity is found
        if(top>down) return -1;
        // Check if the person pointed by top is a celebrity
        for(int i=0; i<n; i++){
            // If top knows someone or someone doesn't know top, it's not a celebrity
            if(i!=top && (arr[top][i]==1 || arr[i][top]==0)){
                return -1;
            }
        }
        // Return the index of the celebrity
        return top;
    }

    public static void main(String[] args) {
        // int[][] arr={{0,1,1,0},{0,0,1,0},{0,0,0,0},{0,1,1,0}};
        int[][] arr={{0,1,1,0},{0,0,0,0},{0,1,0,0},{0,1,0,0}};
        System.out.println(findCelebrity(arr));
    }

}
