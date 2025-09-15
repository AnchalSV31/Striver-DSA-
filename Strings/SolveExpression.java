package Strings;

public class SolveExpression {
    public static int solve(String[] operations){
        int x=0;
        for(String op: operations){
            switch(op){
                case "x++" : case"++x":
                    x=x+1;
                    break;
                default:
                    x=x-1;
            }
         }
        return x;
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"--x", "x++", "x++"};
        System.out.println(solve(operations));
    }
}
