import java.util.ArrayList;

public class twoAddresses {
    public static void EvaluateTwoAddresses(ArrayList<String> postfixExp) {
        ArrayList<Integer> arr2add = new ArrayList<>();
        ArrayList<Integer> registers = new ArrayList<>();
        String c;
        int val;
        int val2;
        int result = 0;
        int count = 0 ;
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
                        ++count;
                        arr2add.remove(arr2add.indexOf(val));
                        arr2add.remove(arr2add.indexOf(val2));
                        arr2add.add(result);
                        int indReg1 = 0;
                        int indReg2 = 0;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val == registers.get(j)) {
                                indReg1 = j+1;
                                registers.set(j, 999999999);
                            }
                            if(val2 == registers.get(j))
                            {
                                indReg2 = j+1;
                                registers.set(j,999999999);
                            }

                        }


                            if (indReg1 != 0 && indReg2 == 0)
                            {
                                System.out.println("Load \t " + "R" + count +"," +val2);
                                System.out.println("Add \t " + "R" + indReg1 + "," + "R" +count );
                                registers.set(indReg1-1,result);
                            }
                            else if (indReg1 == 0 && indReg2 != 0)
                            {
                                System.out.println("Load \t " + "R" + count +"," +val);
                                System.out.println("Add \t " + "R" + indReg2 + "," + "R" +count );
                                registers.set(indReg2-1,result);
                            }
                            else if (indReg2 != 0 && indReg1 != 0)
                            {
                                System.out.println("Add \t " +  "R" + indReg2 + "," + "R" + indReg1);
                                registers.set(indReg2-1,result);
                            }
                            else
                            {
                                registers.add(result);
                                System.out.println("Load \t " + "R" + (registers.indexOf(result)+1)  + "," + val2);
                                System.out.println("Add \t " + "R" + (registers.indexOf(result)+1) + "," + val);
                            }
                        break;
                    case "-":
                        val = arr2add.get(arr2add.size() - 1);
                        val2 = arr2add.get(arr2add.size() - 2);
                        result = val2 - val;
                        ++count;
                        arr2add.remove(arr2add.indexOf(val));
                        arr2add.remove(arr2add.indexOf(val2));
                        arr2add.add(result);

                        indReg1 = 0;
                        indReg2 = 0;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val == registers.get(j)) {
                                indReg1 = j+1;
                                registers.set(j, 999999999);
                            }
                            if(val2 == registers.get(j))
                            {
                                indReg2 = j+1;
                                registers.set(j,999999999);
                            }

                        }


                        if (indReg1 != 0 && indReg2 == 0)
                        {
                            System.out.println("Load \t "  + "R" + count +"," +val2);
                            System.out.println("Subt \t " + "R" + indReg1 + "," + "R" +count );
                            registers.set(indReg1-1,result);
                        }
                        else if (indReg1 == 0 && indReg2 != 0)
                        {
                            System.out.println("Load \t " + "R" + count +"," +val);
                            System.out.println("Subt \t " + "R" + indReg2 + "," + "R" +count );
                            registers.set(indReg2-1,result);
                        }
                        else if (indReg2 != 0 && indReg1 != 0)
                        {
                            System.out.println("Subt \t " +  "R" + indReg2 + "," + "R" + indReg1);
                            registers.set(indReg2-1,result);
                        }
                        else
                        {
                            registers.add(result);
                            System.out.println("Load \t " + "R" + (registers.indexOf(result)+1)  + "," + val2);
                            System.out.println("Subt \t " + "R" + (registers.indexOf(result)+1) + "," + val);
                        }

                        break;
                    case "*":
                        val = arr2add.get(arr2add.size() - 1);
                        val2 = arr2add.get(arr2add.size() - 2);
                        result = val * val2;
                        ++count;
                        arr2add.remove(arr2add.indexOf(val));
                        arr2add.remove(arr2add.indexOf(val2));
                        arr2add.add(result);
                        indReg1 = 0;
                        indReg2 = 0;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val == registers.get(j)) {
                                indReg1 = j+1;
                                registers.set(j, 999999999);
                            }
                            if(val2 == registers.get(j))
                            {
                                indReg2 = j+1;
                                registers.set(j,999999999);
                            }

                        }


                        if (indReg1 != 0 && indReg2 == 0)
                        {
                            System.out.println("Load \t " + "R" + count +"," +val2);
                            System.out.println("Mult \t " + "R" + indReg1 + "," + "R" +count );
                            registers.set(indReg1-1,result);
                        }
                        else if (indReg1 == 0 && indReg2 != 0)
                        {
                            System.out.println("Load \t " + "R" + count +"," +val);
                            System.out.println("Mult \t " + "R" + indReg2 + "," + "R" +count );
                            registers.set(indReg2-1,result);
                        }
                        else if (indReg2 != 0 && indReg1 != 0)
                        {
                            System.out.println("Mult \t " +  "R" + indReg2 + "," + "R" + indReg1);
                            registers.set(indReg2-1,result);
                        }
                        else
                        {
                            registers.add(result);
                            System.out.println("Load \t " + "R" + (registers.indexOf(result)+1)  + "," + val2);
                            System.out.println("Mult \t " + "R" + (registers.indexOf(result)+1) + "," + val);
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
                        ++count;
                        arr2add.remove(arr2add.indexOf(val));
                        arr2add.remove(arr2add.indexOf(val2));
                        arr2add.add(result);
                        indReg1 = 0;
                        indReg2 = 0;

                        for (int j = 0; j < registers.size(); j++) {
                            if (val == registers.get(j)) {
                                indReg1 = j+1;
                                registers.set(j, 999999999);
                            }
                            if(val2 == registers.get(j))
                            {
                                indReg2 = j+1;
                                registers.set(j,999999999);
                            }

                        }


                        if (indReg1 != 0 && indReg2 == 0)
                        {
                            System.out.println("Load \t " + "R" + count +"," +val2);
                            System.out.println("Div \t " + "R" + indReg1 + "," + "R" +count );
                            registers.set(indReg1-1,result);
                        }
                        else if (indReg1 == 0 && indReg2 != 0)
                        {
                            System.out.println("Load \t " + "R" + count +"," +val);
                            System.out.println("Div \t " + "R" + indReg2 + "," + "R" +count );
                            registers.set(indReg2-1,result);
                        }
                        else if (indReg2 != 0 && indReg1 != 0)
                        {
                            System.out.println("Div \t " +  "R" + indReg2 + "," + "R" + indReg1);
                            registers.set(indReg2-1,result);
                        }
                        else
                        {
                            registers.add(result);
                            System.out.println("Load \t " + "R" + (registers.indexOf(result)+1)  + "," + val2);
                            System.out.println("Div \t " + "R" + (registers.indexOf(result)+1) + "," + val);
                        }


                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + c);
                }
            }
        }
        System.out.println("Store \t " + result + ",R1");

    }
}

