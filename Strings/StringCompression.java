package Strings;

public class StringCompression {
    // public static void main(String[] args) {
    //     String str="aaabbbccdee";
    //     String ans=""+str.charAt(0);
    //     int count=1;
    //     for(int i=1;i<str.length(); i++){
    //         char curr=str.charAt(i);
    //         char prev=str.charAt(i-1);
    //         if(curr==prev){
    //             count++;
    //         }
    //         else{
    //             if(count>1) ans=ans+count;
    //             count=1;
    //             ans=ans+curr;
    //         }
    //     }
    //     if(count>1) ans+=count;   //add count for the last element
    //     System.out.println(ans);  
    // }


    //OR


    public static void compress(String str){
        StringBuffer output= new StringBuffer();
        int i=0;
        while(i<str.length()){
            char ch= str.charAt(i);
            int count=0;
            while(i<str.length()){
                if(ch==str.charAt(i)){
                    ++count;
                    ++i;
                }else{
                    break;
                }
            }
            output.append(ch);
            if(count>1) output.append(count);
        }
        System.out.println(output);;
    }

    public static void main(String[] args) {
        compress("aaabbbccdee");
    }
}
