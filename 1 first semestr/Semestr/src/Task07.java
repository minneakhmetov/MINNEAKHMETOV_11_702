import java.util.Scanner;

public class Task07 {
    public static void Task07(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        boolean ability = true;
        if (a+b > c) {
            ability &= true;
        } else {
            ability &= false;
        }


        if (a+c > b) {
            ability &= true;
        } else {
            ability &= false;
        }


        if (b+c > a) {
            ability &= true;
        } else {
            ability &= false;
        }

        if (ability == false) {
            System.out.println("NO");
        } else System.out.println("YES");
    }
}
