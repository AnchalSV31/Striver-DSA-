package Strings;

public class ExpandString {
    public static void expand(String str){
        StringBuffer output= new StringBuffer();
        int i,j,k;
        for(i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            int n= ch-'0';
            StringBuffer temp= new StringBuffer();
            for(j=i+2; str.charAt(j)!=')'; j++){
                temp.append(str.charAt(j));
            }
            for(k=1; k<=n; k++){
                output.append(temp);
            }
            i=j;
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        expand("3(ab)4(cd)");
    }
}
