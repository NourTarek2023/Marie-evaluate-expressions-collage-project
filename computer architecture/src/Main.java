import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Expression converter = new Expression();
        zeroAdresses zeroAdresses = new zeroAdresses();
        oneAddresses oneAddresses = new oneAddresses();
        twoAddresses twoAddresses = new twoAddresses();
        threeAddresses threeAddress = new threeAddresses();

        System.out.println("Welcome to our program :)");
        System.out.println("------------------------------------");
        System.out.println("Please Enter Your expression: ");
        String expression = input.nextLine();

        if (expression.matches("^[0-9+\\-*/()]+$"))
        {
        converter.infixToPostfix(expression);

        while (true) {
            System.out.println("Enter the number of the address type you want to use: ");
            System.out.println("1- Zero Address");
            System.out.println("2- One Address");
            System.out.println("3- Two Address");
            System.out.println("4- Three Address");
            System.out.println("5- Exit");
            int addressType = input.nextInt();
            if (addressType == 1 || addressType == 2 || addressType == 3 || addressType == 4 || addressType == 5) {
                switch (addressType) {
                    case 1 ->{
                        zeroAdresses.EvaluateZero_Address(converter.infixToPostfix(expression));
                        System.out.println("------------------------------------");
                    }

                    case 2 ->
                    {
                        oneAddresses.EvaluateOneAddresses(converter.infixToPostfix(expression));
                        System.out.println("------------------------------------");
                    }
                    case 3 ->
                    {
                        twoAddresses.EvaluateTwoAddresses(converter.infixToPostfix(expression));
                        System.out.println("------------------------------------");
                    }
                    case 4 ->{
                        threeAddress.Evaluate_ThreeAddress(converter.infixToPostfix(expression));
                        System.out.println("------------------------------------");
                    }
                    case 5 ->{
                        System.out.println("Thank you for using our program :)");
                        System.out.println("Dr.Ahmed Mostafa ♥♥♥♥♥♥♥♥♥♥♥♥ <3");
                        System.exit(0);
                    }
                }
            }
            else {
                System.out.println("Invalid input");
                System.out.println("Enter the number of the address type you want to use: ");
                System.out.println("1- Zero Address");
                System.out.println("2- One Address");
                System.out.println("3- Two Address");
                System.out.println("4- Three Address");
                System.out.println("5- Exit");


            }
        }
    }
    else
        {
            System.out.println("Invalid Expression");
            System.exit(0);
        }
    }
}