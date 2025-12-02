import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // Scanner sc= new Scanner(System.in);
        // Long number= sc.nextLong();
        // System.out.println(number);

        // Long number= 914091054l;
        // System.out.println(number);

        // char a='\u00A9';
        // System.out.println(a);

        int a=10;
        int b=20;
        System.out.println(a++ +(b++ +(++a - b++)+ --b));
    }
}