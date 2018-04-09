package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TreeBstImplTest {

    int[] array;

    TreeBstImpl<Integer> tree;

    @Before
    public void setUp(){
        array = new int[]{5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};

        tree = new TreeBstImpl<>();

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
    }

    @Test
    public void equalsTest(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};

        TreeBstImpl<Integer> tree = new TreeBstImpl<>();

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }

        Assert.assertTrue(tree.equals(this.tree));
    }
    @Test
    public void containsTest(){
        Assert.assertTrue(tree.contains(1));
    }


}