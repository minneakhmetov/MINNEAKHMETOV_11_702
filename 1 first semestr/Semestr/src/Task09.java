import java.util.Scanner;

public class Task09 {
    public static void Task09(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a != 0) {
            if (a == 1) System.out.print("x^2");
            if (a == -1) System.out.print("-x^2");
            if (a != 1 && a != -1) System.out.print(a + "x^2");
        }
        if (b != 0) {
            if (b<0) {
                if (b == -1) System.out.print("-x");
                    else System.out.print(b + "x");
            } else
                if (b == 1) System.out.print("x");
                else System.out.print("+" + b + "x");
        }
        if (c != 0) {
            if (c<0) {
                System.out.print(c);
            } else System.out.print("+" + c);
        }
    }
}
