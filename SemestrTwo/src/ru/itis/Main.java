package ru.itis;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Deleter deleter = new Deleter();
        deleter.delete();

        RandomCreator randomCreator = new RandomCreator();
        randomCreator.create();

        Converter converter = new Converter();
        Writer writer = new Writer();
        Sorter sorter = new Sorter();
        GraphData dater = new GraphData();

        int[][] dataArrays = new int[Maximum.MAXIMUM_FILES][];
        String path = new File("").getAbsolutePath();
        int numCount = 0;
        //Сортировка массива
        long time = System.currentTimeMillis();
        for (int i = 0; i < dataArrays.length; i++) {
            String filePath = "\\file" + String.valueOf(i) + ".txt";
            File newFile = new File(path + "\\files" + filePath);
            //dataArrays[i] = new int[randomCreator.size(newFile)];
            dataArrays[i] = converter.convertArray(newFile);
            long timeBefore = System.nanoTime();
            sorter.sort(dataArrays[i]);
            dater.writeTime(System.nanoTime() - timeBefore);
            writer.writeArray(dataArrays[i], newFile);
            numCount += randomCreator.size(newFile);
        }
        System.out.println("Затрачено времени " + (System.currentTimeMillis() - time) + " миллисекунд.");
        //System.out.println("Количество итераций " + sorter.getIteration());
        System.out.println("Количество чисел " + numCount);


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
