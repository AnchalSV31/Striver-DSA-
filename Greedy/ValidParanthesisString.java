package Greedy;

public class ValidParanthesisString {
    //TC: O(3^n) SC: O(n)
    public static boolean isValid(String s, int index, int open){
        if(open<0)return false;

        if(index==s.length())return open==0;

        char c=s.charAt(index);

        if(c=='('){
            return isValid(s, index+1, open+1);
        }else if(c==')'){
            return isValid(s, index+1, open-1);
        }
        // If it's '*', we try all 3 possibilities:
        // 1. Treat '*' as empty string
        // 2. Treat '*' as '('
        // 3. Treat '*' as ')'
        else{
            return isValid(s, index+1, open)|| isValid(s, index+1, open+1) || isValid(s, index+1, open-1);
        }
    }

    //OPTIMAL APPROACH
    //TC: O(n) SC: O(1)
    public static boolean isValid2(String s){
        int minOpen=0;
        int maxOpen=0;

        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);

            if(c=='('){
                minOpen++;
                maxOpen++;
            }else if(c==')'){
                minOpen--;
                maxOpen--;
            }
             // If character is '*', it can be '(', ')' or ''
            else{
                // if '*' is ')'
                minOpen--;
                 // if '*' is '('
                maxOpen++;
            }
            // If maxOpen becomes negative, too many closing brackets : invalid string
            if(maxOpen<0)return false;
            // minOpen can't go below 0, as we can't have negative unmatched '('
            if(minOpen<0)minOpen=0;
        }
        return minOpen==0;
    }

    public static void main(String[] args) {
        String input = "(*))";
        if (isValid(input, 0, 0)) {
            System.out.println("Valid parenthesis string");
        } else {
            System.out.println("Invalid parenthesis string");
        }
        if (isValid2(input)) {
            System.out.println("Valid parenthesis string");
        } else {
            System.out.println("Invalid parenthesis string");
        }
    }
}
