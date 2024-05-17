import java.util.ArrayList;
import java.util.Stack;

public class zeroAdresses {
    static void EvaluateZero_Address(ArrayList<String> postfix) {
        Stack<Integer> stackMarie = new Stack<>();
        String c;
        int value;
        int value2;
        for (int i = 0; i < postfix.size(); i++) {
            c = postfix.get(i);
            if (c.matches("-?\\d+(\\.\\d+)?")) {
                System.out.println("Push " + c);
                stackMarie.push(Integer.parseInt(c));
            } else {
                switch (c) {
                    case "+":
                        value = stackMarie.pop();
                        value2 = stackMarie.pop();
                        System.out.println("Add");
                        stackMarie.push(value + value2);
                        break;
                    case "-":
                        value = stackMarie.pop();
                        value2 = stackMarie.pop();
                        System.out.println("Subt");
                        stackMarie.push(value2 - value);
                        break;
                    case "*":
                        value = stackMarie.pop();
                        value2 = stackMarie.pop();
                        System.out.println("Mult");
                        stackMarie.push(value2 * value);
                        break;
                    case "/":
                        value = stackMarie.pop();
                        value2 = stackMarie.pop();
                        System.out.println("Div");
                        try {
                            stackMarie.push(value2 / value);
                        } catch (ArithmeticException exception) {
                            System.out.println("No Division By Zero");
                            System.exit(0);
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + c);
                }
            }
        }
        if (stackMarie.size() == 1) {
            System.out.println("Store " + stackMarie.peek());
        }
    }
}

