package ru.itis;

import java.util.List;

public class Sorter {
    //класс, сортирующий данные

    int iteration = 0;
     GraphData dater = new GraphData();

    public void sort(int[] a) {
        long time = System.nanoTime();
        iteration = 0;
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
        dater.writeIteration(iteration);
        dater.writeTime(System.nanoTime() - time);
    }


    public void sort(List<Integer> list) {
        long time = System.nanoTime();
        iteration = 0;
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
        dater.writeIteration(iteration);
        dater.writeTime(System.nanoTime() - time);

    }

    public int getIteration() {
        return iteration;
    }
}
