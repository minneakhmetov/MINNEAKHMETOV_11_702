package ru.itis;
import java.time.LocalTime;

public class ParkingPlace {
    private int hour;
    private final int capacity = 20;
    private int free = capacity;
    private boolean ability;
    private String name;
    private String number;
    private Car[] cars = new Car[capacity];

    LocalTime time = LocalTime.now();
    public ParkingPlace() {

    }

    void inputCar(Car car) {
        setAbility(ability);
        if (ability == true) {
            if (free == 0) {
                System.out.println("Нет места в парковке");
            } else {
                for (int i = 0; i < capacity; i++){
                    if (cars[i] == null) {
                        cars[i] = car;
                        System.out.println("Ваше место:" + i);
                        break;
                    }
                }
                --free;
            }
        } else {
            System.out.println("Не работает");
        }
    }

    void outputCar(Car car) {
        setAbility(ability);
        if (ability == true) {
            for (int i = 0; i < capacity; i++) {
                if (cars[i] == car) {
                    cars[i] = null;
                    System.out.println("Ваше место было:" + i);
                    break;
                }
            }
            ++free;
            System.out.println("До свидания!");
            System.out.println(car.getName(name));
            System.out.println(car.getNumber(number));
        } else {
            System.out.println("Не работает");
        }

    }

    public boolean isAbility(boolean ability) {
        return this.ability;
    }

    public void setAbility(boolean ability) {
        hour = time.getHour();
        // System.out.println("Сейчас время: " + hour);
        if (hour > 7 && hour < 22) {
            this.ability = true;
        } else {
            this.ability = false;
        }
    }
}



