package ru.itis;

import java.io.File;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        Deleter deleter = new Deleter();
        deleter.delete();

        RandomCreator randomCreator = new RandomCreator();
        randomCreator.create();

        Converter converter = new Converter();
        Writer writer = new Writer();
        Sorter sorter = new Sorter();

        int[][] dataArrays = new int[Maximum.MAXIMUM_FILES][];
        String path = new File("").getAbsolutePath();
        //Сортировка массива
        long time = System.currentTimeMillis();
        for (int i = 0; i < dataArrays.length; i++) {
            String filePath = "\\file" + String.valueOf(i) + ".txt";
            File newFile = new File(path + "\\files" + filePath);
            //dataArrays[i] = new int[randomCreator.size(newFile)];
            dataArrays[i] = converter.convertArray(newFile);
            sorter.sort(dataArrays[i]);
            writer.writeArray(dataArrays[i], newFile);
        }
        System.out.println("Затрачено времени " + (System.currentTimeMillis() - time) + " миллисекунд.");
        System.out.println("Количество итераций " + sorter.getIteration());


        //Сортировка коллекции
//        List[] dataLists = new List[Maximum.MAXIMUM_FILES];
//        long time = System.currentTimeMillis();
//        for (int i = 0; i < dataLists.length; i++){
//            String filePath = "\\file" + String.valueOf(i) + ".txt";
//            File newFile = new File(path + "\\files" + filePath);
//            dataLists[i] = converter.convertList(newFile);
//            sorter.sort(dataLists[i]);
//            writer.writeList(dataLists[i], newFile);
//        }
//        System.out.println("Затрачено времени " + (System.currentTimeMillis() - time) + " миллисекунд.");
        //System.out.println("Количество итераций " + sorter.getIteration());

    }
}