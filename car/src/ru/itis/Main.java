package ru.itis;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        Auto auto = new Auto();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Model:");
        String model = scanner.nextLine();
        auto.setModel(model);
        System.out.println("Number:");
        int number = scanner.nextInt();
        auto.setNumber(number);
        System.out.println("Power:");
        int power = scanner.nextInt();
        auto.setPower(power);
        System.out.println("Colour:");
        String colour = scanner.next();
        auto.setColour(colour);
        System.out.println("To run:");
        int n = scanner.nextInt();
        auto.go(n);
        auto.show();
    }
}
