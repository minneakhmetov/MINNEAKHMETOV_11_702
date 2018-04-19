package ru.itis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    static int result = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        resulting(age);
        System.out.println(result);
    }

    public static void resulting(int age) {
        File users = new File("C:\\Users\\razil\\Desktop\\MINNEAKHMETOV_11_702\\CarsUsers\\src\\ru\\itis\\users.txt");
        File cars = new File("C:\\Users\\razil\\Desktop\\MINNEAKHMETOV_11_702\\CarsUsers\\src\\ru\\itis\\cars.txt");
        try {
            Scanner usersScanner = new Scanner(users);
            for (int i = 0; i < countLines(users); i++) {
                int userID = readUsers(usersScanner, age);
                if (userID != 0) {
                    Scanner carsScanner = new Scanner(cars);
                    for (int j = 0; j < countLines(cars); j++) {
                        int carID = readCar(carsScanner, userID);
                        if (carID != 0) {
                            result++;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

    }


    public static int readUsers(Scanner carsScanner, int age) {
        Users user = new Users();
        user.id = Integer.valueOf(carsScanner.next());
        user.name = carsScanner.next();
        user.age = Integer.valueOf(carsScanner.next());
        if (age == user.age)
            return user.id;
        else return 0;
    }

    public static int readCar(Scanner carsScanner, int owner_id) {
        Cars car = new Cars();
        car.id = Integer.valueOf(carsScanner.next());
        car.model = carsScanner.next();
        car.owner_id = Integer.valueOf(carsScanner.next());
        if (owner_id == car.owner_id)
            return car.id;
        else return 0;
    }

    public static int countLines(File filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        int count = 0;
        int c = fileReader.read();
        while (c != -1) {
            if (c == '\n')
                count++;
            c = fileReader.read();
        }
        return count;
    }
}
