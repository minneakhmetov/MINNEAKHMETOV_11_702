package ru.itis;
import java.lang.String;

public class Auto {


    String model;
    int number;
    int power;
    String colour;
    int run;


    // public Auto(String model, int number, int power, String colour, int run) {
      //  getModel(model);
       // getNumber(number);
       // getPower(power);
        //getColour(colour);
        //getRun(run);
    // }

    public Auto() {
        this.model = "DEFAULT_MODEL";
        this.number = 0;
        this.power = 0;
        this.colour = "DEFAULT_COLOUR";
        this.run = 0;
    }


    void go(int n) {
        run += n;
    }



    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        } else {
            System.err.println("Неверный номер");
            System.err.println("Задано значение по умолчанию");
            this.number = 0;
        }
    }

    public int getNumber(int number) {
        return this.number;
    }


    public void setPower(int power) {
        if (power > 0) {
            this.power = power;
        } else {
            System.err.println("Неверный номер");
            System.err.println("Задано значение по умолчанию");
            power = 0;
        }
    }
    public int getPower(int power) {
        return this.power;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel(String model) {
        return this.model;
    }


    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour(String colour) {
        return this.colour;
    }



    public void setRun(int run) {
        this.run = run;
    }

    public int getRun(int run) {
        return this.run;
    }

    void show() {
        System.out.println("Модель: " + model);
        System.out.println("Номер: " + number);
        System.out.println("Мощность: " + power);
        System.out.println("Цвет: " + colour);
        System.out.println("Пробег: " + run);
    }

}
