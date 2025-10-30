package SlidingWindow;

//return the minimum window substring of s such that every character in t (including duplicates) is included in the window
public class MinimumWindowSubstring {
    //TC:O(N^2) SC:O(256)
    public static String minWindow(String s1, String s2){
        int minLen=Integer.MAX_VALUE;
        int sIndex=-1;
        int n=s1.length();
        int m=s2.length();

        for(int i=0; i<n; i++){
            int hash[]=new int[256];
           
            for(int j=0; j<m; j++){
                hash[s2.charAt(j)]++;
            }
            int cnt=0;
            for(int j=i; j<n; j++){
                if(hash[s1.charAt(j)]>0){
                    cnt=cnt+1;
                    hash[s1.charAt(j)]--;
                }
                if(cnt==m){
                    if(j-i+1<minLen){
                        minLen=j-i+1;
                        sIndex=i;
                    }
                    break;
                }  
            }
        }
        return (sIndex == -1) ? "" : s1.substring(sIndex, sIndex + minLen);
    }

    //OPTIMIZED APPROACH[SLIDING WINDOW]
    //TC:O(2N)+O(M) SC:O(256)
    public static String minWindow2(String s1, String s2){
        int n=s1.length();
        int m=s2.length();
        int left=0, right=0;
        int cnt=0;
        int minLen=Integer.MAX_VALUE;
        int sIndex=-1;
        int hash[]=new int[256];

        for(int i=0; i<m; i++){
            hash[s2.charAt(i)]++;
        }
        while(right<n){
            if(hash[s1.charAt(right)]>0){
                cnt++;
            }
            hash[s1.charAt(right)]--;
       
            while(cnt==m){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    sIndex=left;
                }
                hash[s1.charAt(left)]++;
                if(hash[s1.charAt(left)]>0){
                    cnt--;
                }
                left++;
            }
            right++;
        }
        return (sIndex == -1) ? "" : s1.substring(sIndex, sIndex + minLen);
    }

    public static void main(String[] args) {
        String s1="DDAAABBCA";
        String s2="ABC";
        System.out.println(minWindow(s1, s2));
        System.out.println(minWindow2(s1, s2));
    }
}
