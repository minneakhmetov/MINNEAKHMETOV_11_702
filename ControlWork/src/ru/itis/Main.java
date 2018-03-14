package ru.itis;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	    Analyzer analyzer = new Analyzer();
	    String string = "A1:=2;A2:=1;A3:=A1/A2;A4:=A3+A1;";
        analyzer.analyze(string);
        LinkedList<String> list = analyzer.process(analyzer.list);
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        //System.out.println(analyzer.find(analyzer.list, "A2"));
    }
}
