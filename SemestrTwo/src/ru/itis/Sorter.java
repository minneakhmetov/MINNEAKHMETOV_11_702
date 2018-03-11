package ru.itis;

import java.util.List;

public class Sorter {
    //класс, сортирующий данные

    int iteration = 0;

    public void sort(int[] a) {
        int maxVal = 0;

        for (int i = 0; i < a.length; i++)
            if (a[i] > maxVal)
                maxVal = a[i];

        int[] bucket = new int[maxVal + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                a[outPos++] = i;
                iteration++;
            }
        }
    }

    public void sort(List<Integer> list) {
        int maxVal = 0;

        for (int i = 0; i < list.size(); i++)
            if (list.get(i) > maxVal)
                maxVal = list.get(i);

        int[] bucket = new int[maxVal + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < list.size(); i++) {
            bucket[list.get(i)]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                list.set(outPos++, i);
                iteration++;
            }
        }
    }

    public int getIteration() {
        return iteration;
    }
}
