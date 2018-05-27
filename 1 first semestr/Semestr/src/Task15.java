import java.util.Scanner;

public class Task15 {
    public static void Task15(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        for (int i=0; i<6; i++){
            sum1 += number % 10;
            number /= 10 ;
            sum2 += number % 10;
            number /= 10;
        }

        if (sum1 == sum2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
