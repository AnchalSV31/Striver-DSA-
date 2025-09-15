package Strings;

//leetcode 8
public class StringToInteger {
    //TC:O(N) SC:O(1)
    public static int myAtoi(String s){
        s=s.trim();
        if(s.length()==0) return 0;
        int i=0, sign=1;
        long res = 0; // use long to prevent overflow

        char op=s.charAt(0);
        if(op=='-'){
            sign=-1;
            i++;
        }else if(op=='+'){
            i++;
        }
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch<'0' || ch>'9'){
                break;
            }
            int digit = ch - '0';
            res = res * 10 + digit;
            if(sign==-1){
                if(-res<=Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
            if(res>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            i++;
        }
        return (int)(res*sign);
    }
    public static void main(String[] args) {
        String str="-259";
        System.out.println(myAtoi(str));
    }
}
