package ru.itis;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class ProcessTest {

    LinkedList<String> listExpected; LinkedList<String> listActual;
    Analyzer analyzer = new Analyzer();

    @Before
    public void setUp(){
        listExpected = new LinkedList<>();
        listExpected.add("A1:=2");
        listExpected.add("A2:=1");
        listActual = new LinkedList<>();
        listActual.add("A1:=2");
        listActual.add("A2:=1");

    }


    @Test
    public void plus(){
        listActual.add("A3:=A1+A2");
        listExpected.add("A3:=3");
        listActual = analyzer.process(listActual);
        Assert.assertEquals(listExpected,listExpected);
    }
    @Test
    public void minus(){
        listActual.add("A3:=A1-A2");
        listExpected.add("A3:=1");
        listActual = analyzer.process(listActual);
        Assert.assertEquals(listExpected,listExpected);
    }
    @Test
    public void division(){
        listActual.add("A3:=A1/A2");
        listExpected.add("A3:=2");
        listActual = analyzer.process(listActual);
        Assert.assertEquals(listExpected,listExpected);
    }
    @Test
    public void multiply(){
        listActual.add("A3:=A1*A2");
        listExpected.add("A3:=2");
        listActual = analyzer.process(listActual);
        Assert.assertEquals(listExpected,listExpected);
    }
    @Test (expected = NotFoundVariableException.class)
    public void exception(){
        listActual.add("A3:=A1*A4");
        listActual = analyzer.process(listActual);
    }


}
