package ru.itis;

import org.junit.Assert;
import org.junit.Test;

public class OptimizatorTest {
    Optimizator optimizator = new Optimizator();

    @Test
    public void test1() {
        int expected = 7;
        int[] parents = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int actual = optimizator.resulting(parents, 10, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int expected = 0;
        int[] parents = {0, 0, 1, 1, 2, 2};
        int actual = optimizator.resulting(parents, 7, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int expected = 0;
        int[] parents = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int actual = optimizator.resulting(parents, 10, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int expected = 3;
        int[] parents = {0, 0, 0, 0, 0, 5, 5, 5, 5, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int actual = optimizator.resulting(parents, 31, 5);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test5() {
        int[] parents = {4, 3, 2, 1};
        int actual = optimizator.resulting(parents, 4, -1);
    }

    @Test
    public void test6() {
        int expected = 0;
        int[] parents = null;
        int actual = optimizator.resulting(parents, 0, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        int expected = 0;
        int[] parents = null;
        int actual = optimizator.resulting(parents, 1, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void test8() {
        int[] parents = {5, 6, 7, 8};
        int actual = optimizator.resulting(parents, 0, 4);

    }

    @Test
    public void test9() {
        int expected = 2;
        int[] parents = {0, 0, 0, 1, 1, 2, 6, 6, 6, 3, 10, 10, 10, 10, 3, 5, 5, 5, 5, 5};
        int actual = optimizator.resulting(parents, 21, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = ArithmeticException.class)
    public void test10() {
        int[] parents = {0, 1, 1};
        int actual = optimizator.resulting(parents, 4, 0);
    }
}
