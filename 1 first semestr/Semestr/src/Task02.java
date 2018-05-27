import java.util.Scanner;


public class Task02 {
    public static void Task02() {
        Scanner scanner = new Scanner(System.in);
        String add1 = scanner.nextLine();
        int letter1 = add1.charAt(0) - 'A' + 1;
        int number1 = add1.charAt(1) - '0';

        String add2 = scanner.nextLine();
        int letter2 = add2.charAt(0) - 'A' + 1;
        int number2 = add2.charAt(1) - '0';


        if (letter1 != letter2) {
            System.out.println("NO");
        }
        if (letter1 == letter2 && (number1 != 2 || number1 != 7)) {
            if ((number1 == 1 || number1 == 8) && (letter1 == letter2)) {
                System.out.println("NO");
            } else {
                if (Math.abs(number2 - number1) > 2) {
                    System.out.println("NO");
                } else {
                    if (Math.abs(number2 - number1) == 2) {
                        System.out.println("YES");
                    } else {
                        if (Math.abs(number2 - number1) == 1) {
                            System.out.println("YES");
                        }
                    }
                }
            }
        }
    }
}