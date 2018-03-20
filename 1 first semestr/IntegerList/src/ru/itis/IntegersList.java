package ru.itis;

import java.util.Random;

public class IntegersList {
    Random rnd = new Random(System.currentTimeMillis());
    int ARRAY_SIZE = 4;
    int[] integersArray = new int[ARRAY_SIZE];


    public IntegersList() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            integersArray[i] = rnd.nextInt(50);
        }
    }

    public IntegersList map(Function function) {
        IntegersList listmap = new IntegersList();
            for (int i = 0; i < integersArray.length; i++) {
                listmap.integersArray[i] = function.apply(integersArray[i]);

        }
        return listmap;
    }

    public IntegersList filter(Predicate predicate) {
        IntegersList filterlist = new IntegersList();
        for (int i = 0; i < integersArray.length; i++) {
            integersArray[i] = integersArray[i];
            if (predicate.test(integersArray[i]) == false) {
                filterlist.integersArray[i] = 0;
            }
        }
        return filterlist;
    }

    public void printList() {
        System.out.println("Принт:");
        for (int i = 0; i < integersArray.length; i++) {
            //if (integersListFiltered[i] != 0)
            System.out.println(integersArray[i]);
        }
    }
}
