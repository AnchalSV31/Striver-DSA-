package Strings;

public class StringConstructors{
    public static void main(String args[]){
        // String city1= new String ("bhopal");
        // String city2= new String ("bhopal");
        // System.out.println(city1==city2);
        

        // //optimized and recommended methods/practice
        // String city3="bhopal";
        // String city4="bhopal";
        // System.out.println(city3==city4);
    
        char[] arr= {'J', 'a', 'v', 'a'};
        String s = new String(arr, 0, 3);
        System.out.println(s);
    
    }

}