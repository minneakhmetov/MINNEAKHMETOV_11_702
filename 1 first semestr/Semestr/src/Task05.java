import java.util.Scanner;

public class Task05 {
    public static void Task05() {
        Scanner scanner = new Scanner(System.in);
        String add1 = scanner.nextLine();
        int letter1 = add1.charAt(0) - 'A' + 1;
        int number1 = add1.charAt(1) - '0';

        String add2 = scanner.nextLine();
        int letter2 = add2.charAt(0) - 'A' + 1;
        int number2 = add2.charAt(1) - '0';
        boolean truth;
        if (Math.abs(letter1 - letter2) == Math.abs(number1 - number2)){
            System.out.println("SAME");
            truth = true;
        }

        if (Math.abs(letter1 - letter2) - Math.abs(number1 - number2) == 1) {
                System.out.println("NEIGHBOUR");
        }
        if ((Math.abs(letter1 - letter2) != Math.abs(number1 - number2) && (Math.abs(letter1 - letter2) - Math.abs(number1 - number2) == 1))) {
            System.out.println("NOT SAME, NOT NEIGHBOUR");
        }
    }
}
