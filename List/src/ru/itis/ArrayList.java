package ru.itis;

public class ArrayList {
    public static final int N = 10;
    int array[] = new int[N];
    int count = 0;

    void addToEnd(int element) {
        if (count >= array.length) {
            int newArray[] = new int[N * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
                // newArray[i+N] =0;
            }
            array = newArray;
        }
        array[count] = element;
        count++;
    }


    void deleteNumber(int index) {
        for (int i=0; i != count - index; i++) {
            array[index + i] = array[index + 1 + i];
        }
        count--;

    }

    void pasteNumber(int number, int index){
        ++count; int k = 0;
        for (int i=count; i > index; i--) {
            k= array[i-1];
            array[i-1] = array[i];
            array[i] = k;
        }
        array[index] = number;
    }

    void showList() {
        for (int i = 0; i < count; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
