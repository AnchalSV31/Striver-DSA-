package Strings;

public class ReverseEachWord {
    //reverse each word in string
    public static void reverseWord1(String str){
        String ans="";
        StringBuilder sb= new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            if(ch==' '){
                sb.reverse();
                ans+=sb;
                ans+=" ";
                sb=new StringBuilder("");
            }
            else{
                sb.append(ch);
            }
        }
        sb.reverse();
        ans+=sb;
        System.out.println(ans);
    }

    //Better approach  TC and SC: O(N)
    public static void reverseWord2(String s) {
        s = s.trim();  // Remove leading & trailing spaces
        String[] words = s.split("\\s+");  // Split by multiple spaces
        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]).append(" ");
        }

        System.out.println(ans.toString().trim()); 
    }
    
    //Optimised Approach SC: O(1)
    public static void reverseWord3(String s) {
        s = s.trim();  // Remove leading & trailing spaces
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
    
        int end = n;
    
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (end - i > 1) {  // Avoid multiple spaces
                    sb.append(s, i + 1, end).append(" ");   //or sb.append(s.substring(i + 1, end)).append(" ");
                }
                end = i; // Move end to the current space
            }
        }
    
        // Add the first word (since the loop skips it)
        sb.append(s, 0, end);
    
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String str="Hello  world educator";
        System.out.println(str);
        reverseWord3(str);
    }
}
