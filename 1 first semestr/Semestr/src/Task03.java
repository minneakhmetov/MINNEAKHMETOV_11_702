import java.util.Scanner;

public class Task03 {
    public static void Task03() {
        Scanner scanner = new Scanner(System.in);
        String add1 = scanner.nextLine();
        int letter1 = add1.charAt(0) - 'A' + 1;
        int number1 = add1.charAt(1) - '0';

        String add2 = scanner.nextLine();
        int letter2 = add2.charAt(0) - 'A' + 1;
        int number2 = add2.charAt(1) - '0';

        if (Math.abs(letter2 - letter1) == 1 && Math.abs(number2 - number1) == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
