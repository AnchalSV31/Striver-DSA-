package Strings;

public class CheckPermutation {
    public static boolean isPermutation(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }

        int[] arr = new int[256];
        int length=s1.length();

        char x;
        int i;
        for(i=0;i<length;i++){
            x=s1.charAt(i);
            arr[x]++;
            x=s2.charAt(i);
            arr[x]--;
        }

        for(i=0; i<length; i++){
            x=s1.charAt(i);
            if(arr[x]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1= "abcd";
        String s2= "dcba";
        System.out.println(isPermutation(s1,s2));
    }
}
