package SlidingWindow;
import java.util.*;


//longest substring with atmost k distinct characters
public class LongestSubstring {
    public static int longestSubstringWithAtmostKDistinct(String s, int k){
        int n=s.length();
        int left=0, right=0;
        int maxLen=0;

        HashMap<Character, Integer> mp= new HashMap<>();

        while(right<n){
            mp.put(s.charAt(right),mp.getOrDefault((s.charAt(right)), 0)+1);
            if(mp.size()>k){
                mp.put(s.charAt(left), mp.get(s.charAt(left))-1);
                if(mp.get(s.charAt(left))==0){
                    mp.remove(s.charAt(left));
                }
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s="aabacbebebe";
        int k=3;
        System.out.println(longestSubstringWithAtmostKDistinct(s, k));
    }
}
