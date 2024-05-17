import java.util.ArrayList;
import java.util.Stack;

public class Expression {
    public ArrayList<String> infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        ArrayList<String> output = new ArrayList<String>();
        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char currentChar = exp.charAt(i);

            if (currentChar == ' ') {
                continue;
            }

            if (Character.isDigit(currentChar))
            {
                currentNumber.append(currentChar);
            }
            else
            {
                if (currentNumber.length() > 0) {
                    output.add(String.valueOf(currentNumber));
                    currentNumber.setLength(0);
                }

                if (currentChar == '(')
                {
                    stack.push('(');
                }
                else if
                (currentChar == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        output.add(String.valueOf(stack.pop()));
                    }
                    stack.pop();
                }
                else
                {
                    while (!stack.isEmpty() && priority(currentChar) <= priority(stack.peek())) {
                        output.add(String.valueOf(stack.pop()));
                    }
                    stack.push(currentChar);
                }
            }
        }

        if (currentNumber.length() > 0) {
            output.add(String.valueOf(currentNumber));
        }


        while (!stack.isEmpty()) {
            output.add(String.valueOf(stack.pop()));
        }

        return output;
    }

    private static int priority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else {
            return 0;
        }
    }


}