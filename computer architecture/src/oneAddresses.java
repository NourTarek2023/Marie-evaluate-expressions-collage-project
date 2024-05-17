import java.util.ArrayList;

public class oneAddresses {
    public static void EvaluateOneAddresses(ArrayList<String> postfixExp) {
        ArrayList<Integer> arr2add = new ArrayList<>();
        ArrayList<Integer> registers = new ArrayList<>();
        String c;
        int val;
        int val2;
        int result = 0;
        int acc = 0 , count = 0;

        for (int i = 0; i < postfixExp.size(); i++) {
            c = postfixExp.get(i);
            if (c.matches("-?\\d+(\\.\\d+)?")) {
                arr2add.add(Integer.parseInt(c));
            } else {
                switch (c) {
                    case "+":
                        val = arr2add.get(arr2add.size() - 1);
                        val2 = arr2add.get(arr2add.size() - 2);
                        result = val + val2;
                        arr2add.remove(arr2add.indexOf(val));
                        arr2add.remove(arr2add.indexOf(val2));
                        arr2add.add(result);
                        int indReg1 = 0;
                        int indReg2 = 0;
                        ++count;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val2 == registers.get(j)) {
                                indReg2 = j+1;
                                registers.set(j, 999999999);
                            }
                            if(val == registers.get(j))
                            {
                                indReg1 = j+1;
                                registers.set(j,999999999);
                            }

                        }
                        if (indReg1 != 0 && indReg2 == 0)
                        {
                            System.out.println("Store \t " + "Temp" + indReg1);
                            System.out.println("load \t " + val2);
                            acc = val2 ;
                            System.out.println("Add \t " + "temp"+indReg1);
                            acc += val ;

                            registers.set(indReg1-1,acc);
                        }
                        else if (indReg1 == 0 && indReg2 != 0)
                        {
                            acc = val2 ;
                            System.out.println("Add \t " + val);
                            acc += val ;
                            registers.set(indReg2-1,acc);
                        }
                        else if (indReg2 != 0 && indReg1 != 0)
                        {
                            System.out.println("Store \t " + "Temp" + indReg1);
                            System.out.println("load \t " + "temp"+indReg2);
                            acc = val2 ;
                            System.out.println("Add \t " +"temp"+indReg1);
                            acc += val ;
                            registers.set(indReg2-1,acc);
                        }
                        else
                        {
                            if (count == 1){
                                System.out.println("load \t " + val2);
                                acc = val2 ;
                                System.out.println("Add \t " + val);
                                acc += val ;
                                registers.add(acc);
                            }
                            else {
                                System.out.println("Store \t " + "Temp" + (registers.indexOf(acc)+1));
                                System.out.println("load \t " + val2);
                                acc = val2;
                                System.out.println("Add \t " + val);
                                acc += val;
                                registers.add(acc);
                            }

                        }
                        break;
                    case "-":
                        val = arr2add.get(arr2add.size() - 1);
                        val2 = arr2add.get(arr2add.size() - 2);
                        result = val2 - val;
                        arr2add.remove(arr2add.indexOf(val));
                        arr2add.remove(arr2add.indexOf(val2));
                        arr2add.add(result);
                        indReg1 = 0;
                        indReg2 = 0;
                        ++count;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val2 == registers.get(j)) {
                                indReg2 = j+1;
                                registers.set(j, 999999999);
                            }
                            if(val == registers.get(j))
                            {
                                indReg1 = j+1;
                                registers.set(j,999999999);
                            }

                        }
                        if (indReg1 != 0 && indReg2 == 0)
                        {
                            System.out.println("Store \t " + "Temp" + indReg1);
                            System.out.println("load \t " + val2);
                            acc = val2 ;
                            System.out.println("Subt \t " + "temp"+indReg1);
                            acc -= val ;
                            registers.set(indReg1-1,acc);
                        }
                        else if (indReg1 == 0 && indReg2 != 0)
                        {
                            acc = val2 ;
                            System.out.println("Subt \t " + val);
                            acc -= val ;
                            registers.set(indReg2-1,acc);
                        }
                        else if (indReg2 != 0 && indReg1 != 0)
                        {
                            System.out.println("Store \t " + "Temp" + indReg1);
                            System.out.println("load \t " + "temp"+indReg2);
                            acc = val2 ;
                            System.out.println("Subt \t " +"temp"+indReg1);
                            acc -= val ;
                            registers.set(indReg2-1,acc);
                        }
                        else
                        {
                            if (count == 1){
                                System.out.println("load \t " + val2);
                                acc = val2 ;
                                System.out.println("subt \t " + val);
                                acc -= val ;
                                registers.add(acc);
                            }
                            else {
                                System.out.println("Store \t " + "Temp" + (registers.indexOf(acc) + 1));
                                System.out.println("load \t " + val2);
                                acc = val2;
                                System.out.println("subt \t " + val);
                                acc -= val;
                                registers.add(acc);
                            }

                        }



                        break;
                    case "*":
                        val = arr2add.get(arr2add.size() - 1);
                        val2 = arr2add.get(arr2add.size() - 2);
                        result = val * val2;
                        arr2add.remove(arr2add.indexOf(val));
                        arr2add.remove(arr2add.indexOf(val2));
                        arr2add.add(result);
                        indReg1 = 0;
                        indReg2 = 0;
                        ++count;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val2 == registers.get(j)) {
                                indReg2 = j+1;
                                registers.set(j, 999999999);
                            }
                            if(val == registers.get(j))
                            {
                                indReg1 = j+1;
                                registers.set(j,999999999);
                            }

                        }

                        if (indReg1 != 0 && indReg2 == 0)
                        {
                            System.out.println("Store \t " + "Temp" + indReg1);
                            System.out.println("load \t " + val2);
                            acc = val2 ;
                            System.out.println("Mult \t " + "temp"+indReg1);
                            acc *= val ;
                            registers.set(indReg1-1,acc);
                        }
                        else if (indReg1 == 0 && indReg2 != 0)
                        {
                            acc = val2 ;
                            System.out.println("Mult \t " + val);
                            acc *= val ;
                            registers.set(indReg2-1,acc);
                        }
                        else if (indReg2 != 0 && indReg1 != 0)
                        {
                            System.out.println("Store \t " + "Temp" + indReg1);
                            System.out.println("load \t " + "temp"+indReg2);
                            acc = val2 ;
                            System.out.println("Mult \t " +"temp"+indReg1);
                            acc *= val ;
                            registers.set(indReg2-1,acc);
                        }
                        else
                        {
                            if (count == 1){
                                System.out.println("load \t " + val2);
                                acc = val2 ;
                                System.out.println("Mult \t " + val);
                                acc *= val ;
                                registers.add(acc);
                            }
                            else {
                                System.out.println("Store \t " + "Temp" + (registers.indexOf(acc) + 1));
                                System.out.println("load \t " + val2);
                                acc = val2;
                                System.out.println("Mult \t " + val);
                                acc *= val;
                                registers.add(acc);
                            }

                        }

                        break;
                    case "/":
                        val = arr2add.get(arr2add.size() - 1);
                        val2 = arr2add.get(arr2add.size() - 2);
                        try {
                            result = val2 / val;
                        }
                        catch(ArithmeticException exception){
                                System.out.println("No Division By Zero");
                                System.exit(0);
                        }
                        arr2add.remove(arr2add.indexOf(val));
                        arr2add.remove(arr2add.indexOf(val2));
                        arr2add.add(result);
                        indReg1 = 0;
                        indReg2 = 0;
                        ++count;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val2 == registers.get(j)) {
                                indReg2 = j+1;
                                registers.set(j, 999999999);
                            }
                            if(val == registers.get(j))
                            {
                                indReg1 = j+1;
                                registers.set(j,999999999);
                            }

                        }
                        if (indReg1 != 0 && indReg2 == 0)
                        {
                            System.out.println("Store \t " + "Temp" + indReg1);
                            System.out.println("load \t " + val2);
                            acc = val2 ;
                            System.out.println("Div \t " + "temp"+indReg1);
                            acc /= val ;
                            registers.set(indReg1-1,acc);
                        }
                        else if (indReg1 == 0 && indReg2 != 0)
                        {
                            acc = val2 ;
                            System.out.println("Div \t " + val);
                            acc /= val ;
                            registers.set(indReg2-1,acc);
                        }
                        else if (indReg2 != 0 && indReg1 != 0)
                        {
                            System.out.println("Store \t " + "Temp" + indReg1);
                            System.out.println("load \t " + "temp"+indReg2);
                            acc = val2 ;
                            System.out.println("Div \t " +"temp"+indReg1);
                            acc /= val ;
                            registers.set(indReg2-1,acc);
                        }
                        else
                        {
                            if (count == 1){
                                System.out.println("load \t " + val2);
                                acc = val2 ;
                                System.out.println("Div \t " + val);
                                acc /= val ;
                                registers.add(acc);
                            }
                            else {
                                System.out.println("Store \t " + "Temp" + (registers.indexOf(acc) + 1));
                                System.out.println("load \t " + val2);
                                acc = val2;
                                System.out.println("Div \t " + val);
                                acc /= val;
                                registers.add(acc);
                            }

                        }

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + c);
                }
            }
        }
        System.out.println("Store \t result (" + acc+")");

    }
}
