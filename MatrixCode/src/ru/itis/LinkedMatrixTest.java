package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LinkedMatrixTest {

    LinkedMatrix linkedMatrix;

    @Before
    public void setUp() {
        linkedMatrix = new LinkedMatrix();
    }


    @Test
    public void testMatrixCode() {
        int[][] arr = new int[2][2];
        arr[0][0] = 2;
        arr[1][1] = 1;
        //arr[0][0] = 2;
        //LinkedMatrix matrix1 = new LinkedMatrix();
        LinkedMatrix matrix = new LinkedMatrix();
        linkedMatrix.insert(0, 0, 2);
        linkedMatrix.insert(1, 1, 1);
        matrix = matrix.MatrixCode(arr);


        Assert.assertTrue(equal(linkedMatrix, matrix));
    }

    @Test
    public void testDecode() {
        int[][] ints = new int[2][2];
        ints[0][0] = 1;
        ints[0][1] = 3;
        ints[1][1] = 2;
        ints[1][0] = 4;
        //LinkedMatrix linkedMatrix = new LinkedMatrix();
        linkedMatrix.insert(0, 0, 1);
        linkedMatrix.insert(1, 1, 2);
        linkedMatrix.insert(0, 1, 3);
        linkedMatrix.insert(1, 0, 4);
        int[][] newInts = linkedMatrix.decode();
        Assert.assertArrayEquals(ints, newInts);
    }

    @Test
    public void testInsert() {
        Node node = new Node(1, 1);
        node.setValue(2);
        linkedMatrix.head = node;
        LinkedMatrix matrix = new LinkedMatrix();
        matrix.insert(1,1,2);

        Assert.assertTrue(equal(linkedMatrix, matrix));
    }
    @Test
    public void testDelete(){
        linkedMatrix.insert(0,0, 1);
        linkedMatrix.insert(0,1,2);
        linkedMatrix.head.next = null;
        linkedMatrix.tail = linkedMatrix.head;
        LinkedMatrix matrix = new LinkedMatrix();
        matrix.insert(0,0,1);
        matrix.insert(1,1,2);
        matrix.delete(1,1);

        Assert.assertTrue(equal(linkedMatrix, matrix));
    }

    @Test
    public void testMinList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        linkedMatrix.insert(0, 0,3);
        linkedMatrix.insert(0, 1, 2);
        linkedMatrix.insert(1,1,1);
        linkedMatrix.insert(1, 0, 2);
        ArrayList<Integer> newList = linkedMatrix.minList();
        Assert.assertEquals(list, newList);
    }
    @Test
    public void sumDiag(){
        linkedMatrix.insert(0,0,1);
        linkedMatrix.insert(1,1,1);
        int sum = linkedMatrix.sumDiag();
        Assert.assertEquals(2, sum);
    }
    @Test
    public void testTransp(){
        linkedMatrix.insert(0, 0, 1);
        linkedMatrix.insert(1, 1, 2);
        linkedMatrix.insert(0, 1, 3);
        linkedMatrix.insert(1, 0, 4);
        linkedMatrix.transp();
        LinkedMatrix matrix = new LinkedMatrix();
        matrix.insert(0, 0, 1);
        matrix.insert(1, 1, 2);
        matrix.insert(1, 0, 3);
        matrix.insert(0, 1, 4);

        Assert.assertTrue(equal(linkedMatrix, matrix));

    }

    @Test
    public void testSumCols(){
        linkedMatrix.insert(0, 0, 1);
        linkedMatrix.insert(1, 1, 2);
        linkedMatrix.insert(0, 1, 3);
        linkedMatrix.insert(1, 0, 4);
        linkedMatrix.sumCols(0, 1);
        LinkedMatrix matrix = new LinkedMatrix();
        matrix.insert(0, 0, 5);
        matrix.insert(1, 1, 2);
        matrix.insert(0, 1, 5);
        matrix.insert(1, 0, 4);

        Assert.assertTrue(equal(linkedMatrix, matrix));
    }

    public boolean equal(LinkedMatrix matrix1, LinkedMatrix matrix2){
        Node node = matrix1.head;
        Node newNode = matrix2.head;
        boolean result = true;
        while (node != null & newNode != null){
            if (node.getValue() != newNode.getValue())
                result = false;
            node = node.next;
            newNode = newNode.next;
        }
        return result;
    }



}
