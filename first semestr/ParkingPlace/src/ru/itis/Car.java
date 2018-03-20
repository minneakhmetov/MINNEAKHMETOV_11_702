package ru.itis;

public class Car {
    ParkingPlace parkingplace;
    private String name;
    private String number;

    public Car(String name, String number) {
        setName(name);
        setNumber(number);
    }


    void goIn(ParkingPlace parkingplace) {
        parkingplace.inputCar(this);
    }

    void goOut(ParkingPlace parkingplace) {
        parkingplace.outputCar(this);
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(String name){
        return this.name;
    }
    public String getNumber(String number) {
        return this.number;
    }
    public void setNumber(String number){
        this.number = number;
    }
}

