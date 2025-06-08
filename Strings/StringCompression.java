package Strings;

public class StringCompression {
    public static void main(String[] args) {
        String str="aaabbbccdee";
        String ans=""+str.charAt(0);
        int count=1;
        for(int i=1;i<str.length(); i++){
            char curr=str.charAt(i);
            char prev=str.charAt(i-1);
            if(curr==prev){
                count++;
            }
            else{
                if(count>1) ans=ans+count;
                count=1;
                ans=ans+curr;
            }
        }
        if(count>1) ans+=count;   //add count for the last element
        System.out.println(ans);  
    }
}
