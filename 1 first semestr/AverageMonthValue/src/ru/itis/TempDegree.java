package ru.itis;

public class TempDegree {
    int day;
    int month;
    double tempValue;

    public TempDegree(int day, int month, double tempValue) {
        this.day = day;
        this.month = month;
        this.tempValue = tempValue;
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getTempValue() {
        return tempValue;
    }

    public void setTempValue(double tempValue) {
        this.tempValue = tempValue;
    }


}
