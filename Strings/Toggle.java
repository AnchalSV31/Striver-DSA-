package Strings;
import java.util.*;

public class Toggle {
    //convert all uppercase into lowercase and vice versa
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        System.out.println(str);

        for(int i=0; i<str.length();i++){
            boolean flag=true;  //true->capital
            char ch=str.charAt(i);
            if(ch==' ') continue;
            int asci=(int)ch;
            if(asci>=97) flag=false;  //small
            if(flag==true){    //capital
                asci+=32;
                char dh=(char)asci;
                str.setCharAt(i,dh);
                }
            else{   //small
                asci-=32;
                char dh=(char)asci;
                str.setCharAt(i, dh);
            }
        }
        System.out.println(str);
    }

}
