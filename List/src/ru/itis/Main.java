package ru.itis;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        int input =0;
        while (input != 5) {
            System.out.println(" ");
            System.out.println("************* MENU: *************");
            System.out.println("1. Paste a number in the end of array;");
            System.out.println("2. Delete a number in the array; ");
            System.out.println("3. Paste a number in the array; ");
            System.out.println("4. Write down the array; ");
            System.out.println("5. Exit");
            System.out.println("*********************************");
            System.out.println(" ");
            input = scanner.nextInt();
            if (input == 1) {
                int n = scanner.nextInt();
                list.addToEnd(n);
            }

            if (input == 2) {
                int n = scanner.nextInt();
                list.deleteNumber(n);
            }
            if (input == 3) {
                int number = scanner.nextInt(); int n = scanner.nextInt();
                list.pasteNumber(number, n);
            }
            if (input == 4)  list.showList();

        }
    }
}
