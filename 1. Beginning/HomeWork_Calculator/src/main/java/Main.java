import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a;
        int b;
        char op;
        int res;
        System.out.println("Enter first number: ");
        a = input.nextInt();
        System.out.println("Enter second number: ");
        b = input.nextInt();
        System.out.println("Choose an operator: +, -, *, or /");
        op = input.next().charAt(0);
        switch (op) {
            case '+':
                res = a + b;
                System.out.println(a + " + " + b + " = " + res);
                break;
            case '-':
                res = a - b;
                System.out.println(a + " - " + b + " = " + res);
                break;
            case '*':
                res = a * b;
                System.out.println(a + " * " + b + " = " + res);
                break;
            case '/':
                res = a / b;
                System.out.println(a + " / " + b + " = " + res);
                break;
            default:
                System.out.println("Invalid Operator!");
                break;
        }

        input.close();
    }
}
