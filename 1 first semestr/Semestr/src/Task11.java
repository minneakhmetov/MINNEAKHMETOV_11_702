import java.util.Scanner;

public class Task11 {
    public static void Task11(){
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        double ab = Math.abs((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        double bc = Math.abs((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));
        double ac = Math.abs((x3-x2)*(x3-x2) + (y3-y2)*(y3-y2));
        double p = (ab+bc+ac)/2;
        double sum = Math.sqrt(p*(p-ac)*(p-bc)*(p-ac));
        System.out.println("Площадь:" + sum);
    }
}
