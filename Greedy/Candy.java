package Greedy;
import java.util.*;

public class Candy {
    //TC:O(N^2) SC:O(N)
    public static int minCandy(int[] ratings){
        int n=ratings.length;

        int[] candies=new int[n];
        Arrays.fill(candies, 1);

        boolean updated=true;

        while(updated){
            updated=false;
            // Left to Right pass
            for(int i=1; i<n; i++){
                if(ratings[i]>ratings[i-1] && candies[i]<=candies[i-1]){
                    candies[i]=candies[i-1]+1;
                    updated=true;
                }
            }
            // Right to left pass
            for(int i=n-2; i>=0; i--){
                if(ratings[i]>ratings[i+1] && candies[i]<=candies[i+1]){
                    candies[i]=candies[i+1]+1;
                    updated=true;
                }
            }
        }
        //Sum up the total candies
        int total=0;
        for(int candy: candies){
            total+=candy;
        }
        return total;
    }

    //BETTER APPROACH
    //TC:O(N) SC:O(N)
    public static int minCandy2(int[] ratings){
        int n=ratings.length;
        int[] candies= new int[n];

        // Initialize each child with 1 candy
        for(int i=0; i<n; i++){
            candies[i]=1;
        }

        // Traverse from left to right
        for(int i=1; i<n; i++){
            // If current rating is higher than previous, give more candies
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        // Traverse from right to left
        for(int i=n-2; i>=0; i--){
            // If current rating is higher than next, give more candies
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i], candies[i+1]+1);
            }
        }

        //sum up all candies
        int total=0;
        for(int c: candies){
            total+=c;
        }
        return total;
    }

    //OPTIMAL APPROACH
    //TC:O(N) SC:O(1)
    public static int minCandy3(int[] ratings){
        int n=ratings.length;
        int candies=1;
        int i=1;

        while(i<n){
            //skip equal ratings
            if(ratings[i]==ratings[i-1]){
                candies++;
                i++;
                continue;
            }

            int peak=1;

            while(i<n && ratings[i]>ratings[i-1]){
                peak++;
                candies+=peak;
                i++;
            }

            int down=1;
            while(i<n && ratings[i]<ratings[i-1]){
                candies+=down;
                i++;
                down++;
            } 
            if(down>peak){
                candies+=down-peak;
            }
        }
        return candies;
    }

    public static void main(String[] args) {
        int[] ratings={1,3,2,1};
        System.out.println(minCandy(ratings));
        System.out.println(minCandy2(ratings));
        System.out.println(minCandy3(ratings));
    }
}
