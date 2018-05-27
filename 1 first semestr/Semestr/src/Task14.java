import java.util.Scanner;

public class Task14 {
    public static void Task14(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        for (int i=0; i<3; i++){
            sum1 += number % 10;
            number /= 10 ;
        }
        for (int i=0; i<3; i++){
            sum2 += number % 10;
            number /= 10;
        }
        if (sum1 == sum2) {
            System.out.println("YEAH");
        } else {
            System.out.println("NO GOD PLEASE NOOOOOOOOOOOO");
        }
    }
}
