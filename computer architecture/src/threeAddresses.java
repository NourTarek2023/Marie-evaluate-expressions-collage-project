import java.util.ArrayList;

public class threeAddresses {
     void Evaluate_ThreeAddress(ArrayList<String> postfixExp) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> registers = new ArrayList<>();
        String c;
        int val;
        int val2;
        int result = 0;
        int count = 0;
        for (int i =0 ; i<postfixExp.size(); i++){
            c=postfixExp.get(i);
            if (c.matches("-?\\d+(\\.\\d+)?")){
                arr.add(Integer.parseInt(c));
            }
            else {
                switch (c) {
                    case "+":
                        val = arr.get(arr.size() - 1);
                        val2 = arr.get(arr.size() - 2);
                        result = val + val2;
                        count++;
                        arr.remove(arr.indexOf(val));
                        arr.remove(arr.indexOf(val2));
                        arr.add(result);
                        int indReg1 = 0;
                        int indReg2 = 0;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val2 == registers.get(j)) {
                                indReg2 = j + 1;
                                registers.set(j, 999999999);
                            }
                            if (val == registers.get(j)) {
                                indReg1 = j + 1;
                                registers.set(j, 999999999);
                            }
                        }

                        registers.add(result);

                        if (i == postfixExp.size() - 1) {
                            if (indReg2 != 0 && indReg1 != 0) {
                                System.out.println("Add \t " + result + " , " + "R" + indReg2 + " , " + "R" + indReg1);
                            } else if (indReg2 != 0 && indReg1 == 0){
                                System.out.println("Add \t " + result + " , " + "R" + indReg2 + " , " + val);
                            }
                            else if (indReg1 != 0 && indReg2 == 0)
                            {
                                System.out.println("Add \t " + result + " , " + "R" + indReg1 + " , " + val2);
                            }
                            else
                            {
                                System.out.println("Add \t " + "R" + count + " , "+val + " , " + val2);

                            }

                        } else {
                            if (indReg1 != 0 && indReg2 == 0) {
                                System.out.println("Add \t " + "R" + count + " , " + val2 + " , " + "R" + indReg1);
                            } else if (indReg2 != 0 && indReg1 == 0) {
                                System.out.println("Add \t " + "R" + count + " , " + "R" + indReg2 + " , " + val);
                            } else if (indReg2 != 0 && indReg1 != 0) {

                                System.out.println("Add \t " + "R" + count + " , " + "R" + indReg2 + " , " + "R" + indReg1);
                            } else
                                System.out.println("Add \t " + "R" + count + " , " + val2 + " , " + val);
                        }
                        break;
                    case "-":
                        val = arr.get(arr.size() - 1);
                        val2 = arr.get(arr.size() - 2);
                        result = val2 - val;
                        count++;
                        arr.remove(arr.indexOf(val));
                        arr.remove(arr.indexOf(val2));
                        arr.add(result);
                        indReg1 = 0;
                        indReg2 = 0;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val2 == registers.get(j)) {
                                indReg2 = j + 1;
                                registers.set(j, 999999999);
                            }
                            if (val == registers.get(j)) {
                                indReg1 = j + 1;
                                registers.set(j, 999999999);
                            }
                        }

                        registers.add(result);

                        if (i == postfixExp.size() - 1) {
                            if (indReg2 != 0 && indReg1 != 0) {
                                System.out.println("Subt \t " + result + " , " + "R" + indReg2 + " , " + "R" + indReg1);
                            } else if (indReg2 != 0 && indReg1 == 0){
                                System.out.println("Subt \t " + result + " , " + "R" + indReg2 + " , " + val);
                            }
                            else if (indReg1 != 0 && indReg2 == 0)
                            {
                                System.out.println("Subt \t " + result + " , " + "R" + indReg1 + " , " + val2);
                            }
                            else
                            {
                                System.out.println("Subt \t " + "R" + count + " , " + val + " , " + val2);

                            }

                        }else {
                            if (indReg1 != 0 && indReg2 == 0) {
                                System.out.println("Subt \t " + "R" + count + " , " + val2 + " , " + "R" + indReg1);
                            } else if (indReg2 != 0 && indReg1 == 0) {
                                System.out.println("Subt \t " + "R" + count + " , " + "R" + indReg2 + " , " + val);
                            } else if (indReg2 != 0 && indReg1 != 0) {

                                System.out.println("Subt \t " + "R" + count + " , " + "R" + indReg2 + " , " + "R" + indReg1);
                            } else
                                System.out.println("Subt \t " + "R" + count + " , " + val2 + " , " + val);
                        }
                        break;
                    case "*":
                        val = arr.get(arr.size() - 1);
                        val2 = arr.get(arr.size() - 2);
                        result = val * val2;
                        count++;

                        arr.remove(arr.indexOf(val));
                        arr.remove(arr.indexOf(val2));
                        arr.add(result);
                        indReg1 = 0;
                        indReg2 = 0;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val2 == registers.get(j)) {
                                indReg2 = j + 1;
                                registers.set(j, 999999999);
                            }
                            if (val == registers.get(j)) {
                                indReg1 = j + 1;
                                registers.set(j, 999999999);
                            }
                        }

                        registers.add(result);

                        if (i == postfixExp.size() - 1) {
                            if (indReg2 != 0 && indReg1 != 0) {
                                System.out.println("Mult \t " + result + " , " + "R" + indReg2 + " , " + "R" + indReg1);
                            } else if (indReg2 != 0 && indReg1 == 0){
                                System.out.println("Mult \t " + result + " , " + "R" + indReg2 + " , " + val);
                            }
                            else if (indReg1 != 0 && indReg2 == 0)
                            {
                                System.out.println("Mult \t " + result + " , " + "R" + indReg1 + " , " + val2);
                            }
                            else
                            {
                                System.out.println("Mult \t " + "R" + count + " , " + val + " , " + val2);

                            }

                        } else {
                            if (indReg1 != 0 && indReg2 == 0) {
                                System.out.println("Mult \t " + "R" + count + " , " + val2 + " , " + "R" + indReg1);
                            } else if (indReg2 != 0 && indReg1 == 0) {
                                System.out.println("Mult \t " + "R" + count + " , " + "R" + indReg2 + " , " + val);
                            } else if (indReg2 != 0 && indReg1 != 0) {

                                System.out.println("Mult \t " + "R" + count + " , " + "R" + indReg2 + " , " + "R" + indReg1);
                            } else
                                System.out.println("Mult \t " + "R" + count + " , " + val2 + " , " + val);
                        }
                        break;
                    case "/":
                        val = arr.get(arr.size() - 1);
                        val2 = arr.get(arr.size() - 2);
                        try {
                            result = val2 / val;
                        }
                        catch(ArithmeticException exception){
                            System.out.println("No Division By Zero");
                            System.exit(0);
                        }
                        count++;
                        arr.remove(arr.indexOf(val));
                        arr.remove(arr.indexOf(val2));
                        arr.add(result);
                        indReg1 = 0;
                        indReg2 = 0;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val2 == registers.get(j)) {
                                indReg2 = j + 1;
                                registers.set(j, 999999999);
                            }
                            if (val == registers.get(j)) {
                                indReg1 = j + 1;
                                registers.set(j, 999999999);
                            }
                        }

                        registers.add(result);

                        if (i == postfixExp.size() - 1) {
                            if (indReg2 != 0 && indReg1 != 0) {
                                System.out.println("Div \t " + result + " , " + "R" + indReg2 + " , " + "R" + indReg1);
                            } else if (indReg2 != 0 && indReg1 == 0){
                                System.out.println("Div \t " + result + " , " + "R" + indReg2 + " , " + val);
                            }
                            else if (indReg1 != 0 && indReg2 == 0)
                            {
                                System.out.println("Div \t " + result + " , " + "R" + indReg1 + " , " + val2);
                            }
                            else
                            {
                                System.out.println("Div \t " + "R" + count + " , " + val + " , " + val2);

                            }

                        } else {
                            if (indReg1 != 0 && indReg2 == 0) {
                                System.out.println("Div \t " + "R" + count + " , " + val2 + " , " + "R" + indReg1);
                            } else if (indReg2 != 0 && indReg1 == 0) {
                                System.out.println("Div \t " + "R" + count + " , " + "R" + indReg2 + " , " + val);
                            } else if (indReg2 != 0 && indReg1 != 0) {

                                System.out.println("Div \t " + "R" + count + " , " + "R" + indReg2 + " , " + "R" + indReg1);
                            } else
                                System.out.println("Div \t " + "R" + count + " , " + val2 + " , " + val);
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + c);

                }
            }
        }
        System.out.println("The final Result is : " + result);
    }
}

