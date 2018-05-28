package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTest {
    Tree treeExpected;
    Tree treeActual;

    @Before
    public void setUp(){
        treeExpected = new Tree();
        treeActual = new Tree();


    }
    @Test
    public void test1(){
        treeExpected.insert(new Node("*"), null);
        treeExpected.insert(new Node("+"), treeExpected.root);
        treeExpected.insert(new Node("+"), treeExpected.root);
        treeExpected.insert(new Node("3"), treeExpected.root.left);
        treeExpected.insert(new Node("41"), treeExpected.root.left);
        treeExpected.insert(new Node("9"), treeExpected.root.right);
        treeExpected.insert(new Node("1"), treeExpected.root.right);
        try {
            treeActual.add("(( 3+ 41) * (  9 + 1     )  ) ");
        } catch (SyntaxException e) {
            Assert.fail();
        }
        Assert.assertTrue(treeExpected.equals(treeActual));
    }
    @Test
    public void test2(){
        treeExpected.insert(new Node("*"), null);
        treeExpected.insert(new Node("+"), treeExpected.root);
        treeExpected.insert(new Node("-"), treeExpected.root);
        treeExpected.insert(new Node("6"), treeExpected.root.left);
        treeExpected.insert(new Node("90209"), treeExpected.root.left);
        treeExpected.insert(new Node("9"), treeExpected.root.right);
        treeExpected.insert(new Node("1"), treeExpected.root.right);
        try {
            treeActual.add("(( 6+ 90209) * (  9 - 1     )  ) ");
        } catch (SyntaxException e) {
            Assert.fail();
        }
        Assert.assertTrue(treeExpected.equals(treeActual));
    }
    @Test (expected = SyntaxException.class)
    public void test3() throws SyntaxException{
        treeActual.add("knwjvknwe");
    }
}
