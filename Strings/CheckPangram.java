package Strings;

//PANGRAM- A sentence which contains all the letters of English Alphabet
public class CheckPangram {
    public static boolean isPangram(String str){
        boolean[] result= new boolean[26];
        for(int i=0; i<str.length(); i++){
            char ch= str.charAt(i);
            if(Character.isAlphabetic(ch)){
                ch=Character.toLowerCase(ch);
                result[ch-'a']=true;
            }
        }
        for(boolean x: result){
            if(x==false) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str="The quick brown fox jumps over the lazy dog";
        System.out.println(isPangram(str));
    }
}
