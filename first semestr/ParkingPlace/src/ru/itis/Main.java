package ru.itis;

public class Main {

    public static void main(String[] args) {
        ParkingPlace parking = new ParkingPlace();
        Car car = new Car("matiz", "234");
        Car car1 = new Car("vevr", "srver");
        Car car2 = new Car("vevr", "srver");
        car.goIn(parking);
        car1.goIn(parking);
        car2.goIn(parking);
        car2.goOut(parking);
        car.goOut(parking);
    }
}
