package StackNQueue;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + infixToPostfix(exp));
    }

    //Infix to postfix
    static int Prec(char ch) {
        switch (ch) {
        case '+':
        case '-':
          return 1;
    
        case '*':
        case '/':
          return 2;
    
        case '^':
          return 3;
        }
        return -1;
    }

    
    static String infixToPostfix(String exp) {
    // initializing empty String for result
    String result = new String("");

    // initializing empty stack
    Stack < Character > stack = new Stack < > ();

    for (int i = 0; i < exp.length(); ++i) {
      char c = exp.charAt(i);

      // If the scanned character is an
      // operand, add it to output.
      if (Character.isLetterOrDigit(c))
        result += c;

      // If the scanned character is an '(',
      // push it to the stack.
      else if (c == '(')
        stack.push(c);

      // If the scanned character is an ')',
      // pop and output from the stack
      // until an '(' is encountered.
      else if (c == ')') {
        while (!stack.isEmpty() &&
          stack.peek() != '(')
          result += stack.pop();

        stack.pop();
      } else // an operator is encountered
      {
        while (!stack.isEmpty() && Prec(c) <=
          Prec(stack.peek())) {

          result += stack.pop();
        }
        stack.push(c);
      }

    }

    // pop all the operators from the stack
    while (!stack.isEmpty()) {
      if (stack.peek() == '(')
        return "Invalid Expression";
      result += stack.pop();
    }
    return result;
  }


    
}
