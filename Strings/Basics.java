package Strings;
import java.util.*;

public class Basics {
    public static void main(String[] args) {
        // Scanner sc= new Scanner(System.in);
        // String s=sc.next();
        // String s=sc.nextLine();
        // System.out.println(s);

        // String s="Hello World";
        // System.out.println(s.length());
        // System.out.println(s.charAt(4));
        // System.out.println(s.indexOf("l"));

        // String l="Dello";
        // System.out.println(s.compareTo(l));   //if s>l lexographically then returns +ve number, else -ve

        // System.out.println(s.contains("ellow"));
        // System.out.println(s.startsWith("Hel"));
        // System.out.println(s.endsWith("ld"));
        // System.out.println(s.toLowerCase());
        // System.out.println(s.toUpperCase());

        // String s1="abc";
        // String s2="def";
        // System.out.println(s1.concat(s2));

        // String s1="abc";
        // s1=s1+"xyz";
        // s1+="r";
        // s1+="9";
        // System.out.println(s1);
        // System.out.println("abc"+10+20);


        //Substring
        // String s="abcde";
        // System.out.println(s.substring(2,4));
        // System.out.println(s.substring(2));

        //PRINT ALL SUBSTRINGS
        // for(int i=0;i<s.length();i++){
        //     for(int j=i+1;j<=s.length();j++){
        //         System.out.print(s.substring(i,j)+" ");
        //     }
        // }


        //INTERNING AND NEW
        // String s="Hello";
        // String x="Hello";
        // x="Mello";
        // System.out.println(x);


        //IMMUTABILITY
        // String s="Hello";  //->Heylo //2
        // s="Heylo";
        // s=s.substring(0,2)+'y'+ s.substring(3);
        // System.out.println(s);


        //PERFORMANCE OF STRINGS
        // String str="";
        // for(int i=0; i<=10; i++){
        //     str=str+i;
        // }
        // System.out.println(str);

        String s1="hello";
        String s2="hello";
        String s3= new String("hello");
        System.out.println(s1==s2);  //same address
        System.out.println(s1==s3);   //diff address
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }
}
