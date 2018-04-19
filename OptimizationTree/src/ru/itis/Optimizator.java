package ru.itis;

public class Optimizator {

    public int resulting(int[] parents, int size, int k) {
        int result = 0;
        if (parents != null) {
            int[] counting = new int[size - 1];

            for (int i = 0; i < parents.length; i++)
                counting[parents[i]]++;

            for (int i = 0; i < counting.length; i++) {
                while (counting[i] > k) {
                    result += counting[i] / k;
                    counting[i] -= (counting[i] / k) * (k - 1);
                }
            }
        }
        return result;
    }
}
