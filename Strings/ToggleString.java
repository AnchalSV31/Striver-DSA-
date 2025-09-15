package Strings;

import java.util.*;

public class ToggleString {
    public static void main(String[] args) {
        String str="PhYSicS";
        // StringBuilder str = new StringBuilder(sc.nextLine());
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
                // str.setCharAt(i,dh);
                str=str.substring(0,i)+dh+str.substring(i+1);
                }
            else{   //small
                asci-=32;
                char dh=(char)asci;
                // str.setCharAt(i, dh);
                str=str.substring(0,i)+dh+str.substring(i+1);

            }
        }
        System.out.println(str);
    }
}
