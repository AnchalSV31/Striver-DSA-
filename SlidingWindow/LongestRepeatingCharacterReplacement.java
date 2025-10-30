package SlidingWindow;
import java.util.*;

public class LongestRepeatingCharacterReplacement {
    //TC:   ~O(N^2) SC: O(26)
    public static int charReplacement(String s, int k){
        int n=s.length();
        int len=0;
        int maxFreq=0;
        int[] hash = new int[26];

        for(int i=0; i<n; i++){
            Arrays.fill(hash, 0);
            maxFreq=0;
            for(int j=i; j<n; j++){
                hash[s.charAt(j)-'A']++;
                maxFreq=Math.max(maxFreq, hash[s.charAt(j)-'A']);
                if((j-i+1)-maxFreq>k){
                    break;
                }else{
                    len=Math.max(len, j-i+1);
                }
            }
            
        }
        return len;
    }

    //TC:O(N+N)*26 SC:O(26)
    public static int charReplacement2(String s, int k){
        int n=s.length();
        int left=0, right=0;
        int maxFreq=0;
        int len=0;
        int hash[]= new int[26];

        while(right<n){
            hash[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq, hash[s.charAt(right)-'A']);

            while((right-left+1)-maxFreq>k){
                hash[s.charAt(left)-'A']--;
                maxFreq=0;
                for(int i=0; i<26; i++){
                    maxFreq=Math.max(maxFreq, hash[i]);
                }
                left++;
            }

            if((right-left+1)-maxFreq<=k){
                len=Math.max(len, right-left+1);
            }
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s="AABABBA";
        int k=2;
        System.out.println(charReplacement(s, k));
        System.out.println(charReplacement2(s, k));
    }
}
