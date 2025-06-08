package Strings;
import java.util.*;

public class Builder {
    //mutable
    public static void main(String[] args) {
        StringBuilder str= new StringBuilder("hello");
        // str.append("world");
        System.out.println(str);

        //hello-> mello
        // str.setCharAt(0,'m');
        // System.out.println(str);

        // str.append("true");
        // str.append(10);
        // System.out.println(str);

        //hello-> heyllo
        // str.insert(2,'y');
        // System.out.println(str);

        // str.deleteCharAt(0);
        // System.out.println(str);

        // str.reverse();
        // System.out.println(str);

        // str.delete(2,4);
        // System.out.println(str);

        System.out.println(str.substring(3));
    }
    

}
