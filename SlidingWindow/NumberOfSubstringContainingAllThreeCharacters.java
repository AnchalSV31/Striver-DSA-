package SlidingWindow;
import java.util.*;


public class NumberOfSubstringContainingAllThreeCharacters {
    //TC: ~O(N^2) SC:O(1)
    public static int numberOfSubstrings(String s){
        int n=s.length();
        int count=0;
        int[] hash = new int[3];

        for(int i=0; i<n; i++){
            Arrays.fill(hash, 0);
            for(int j=i; j<n; j++){
                hash[s.charAt(j)-'a']=1;
                if(hash[0]+hash[1]+hash[2]==3){
                    // count++;
                    count=count+(n-j);
                    break;
                }
            }
        }
        return count;
    }

    //TC:O(N) SC:O(1)
    public static int numberOfSubstrings2(String s){
        int n=s.length();
        int i=0, j=0, count=0;
        int[] hash= new int[3];

        while(j<n){
            hash[s.charAt(j)-'a']++;
            j++;
        
            while(hash[0]>0 && hash[1]>0 && hash[2]>0){
                count=count+(n-j+1);
                hash[s.charAt(i)-'a']--;
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s="bbacba";
        System.out.println(numberOfSubstrings(s));
        System.out.println(numberOfSubstrings2(s));
    }
}
