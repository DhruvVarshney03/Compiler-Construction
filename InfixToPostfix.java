import java.util.Scanner;

class InfixToPostfix {
    // Function to check if a character is an operator
    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/'|| c == '^');
    }

    // Function to get the precedence of an operator
    static int getPrecedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        else if (op == '*' || op == '/')
            return 2;
        else if (op == '^')
            return 3;
        
        return 0;
    }

    // Function to convert infix expression to postfix expression
    static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        StringBuilder stack = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.append(c);
            } else if (c == ')') {
                while (stack.length() > 0 && stack.charAt(stack.length() - 1) != '(') {
                    postfix.append(stack.charAt(stack.length() - 1));
                    stack.deleteCharAt(stack.length() - 1);
                }
                stack.deleteCharAt(stack.length() - 1); // Pop '(' from the stack
            } else if (isOperator(c)) {
                while (stack.length() > 0 && getPrecedence(c) <= getPrecedence(stack.charAt(stack.length() - 1))) {
                    postfix.append(stack.charAt(stack.length() - 1));
                    stack.deleteCharAt(stack.length() - 1);
                }
                stack.append(c);
            }
        }

        while (stack.length() > 0) {
            postfix.append(stack.charAt(stack.length() - 1));
            stack.deleteCharAt(stack.length() - 1);
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infixExpression;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an infix expression: ");
        infixExpression = scanner.nextLine();

        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Postfix expression: " + postfixExpression);

        
    }
}
