package ru.itis;

public class NewThread extends java.lang.Thread {

    int array[];
    int sum = 0;

    public NewThread(int array[]) {
        this.array = array;
    }

    @Override
    public void run() {
        for(int i = 0; i < array.length; i++){
            System.out.println(Thread.currentThread().getName());
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }
}
