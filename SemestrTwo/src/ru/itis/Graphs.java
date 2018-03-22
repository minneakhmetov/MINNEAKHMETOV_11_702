package ru.itis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.File;

public class Graphs extends Application {

    public static void main(String[] args) {
        Deleter deleter = new Deleter();
        deleter.delete();

        RandomCreator randomCreator = new RandomCreator();
        randomCreator.create();

        Converter converter = new Converter();
        Writer writer = new Writer();
        Sorter sorter = new Sorter();
        GraphData dater = new GraphData();
        Graphs graph = new Graphs();

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
            //long timeBefore = System.nanoTime();
            sorter.sort(dataArrays[i]);
            //dater.writeTime(System.nanoTime() - timeBefore);
            //dater.writeIteration(iteration);
            writer.writeArray(dataArrays[i], newFile);
            numCount += randomCreator.size(newFile);
            dater.writeCount(newFile);
        }
        System.out.println("Затрачено времени " + (System.currentTimeMillis() - time) + " миллисекунд.");
        System.out.println("Количество чисел " + numCount);

        launch(args);
    }


    @Override
    public void start(Stage stage) {

        String path = new File("").getAbsolutePath() + "\\graphData";
        File iteration = new File(path + "\\iterationData.txt");
        File time = new File(path + "\\time.txt");
        File countNumbers = new File(path + "\\countNumbers.txt");
        GraphData dater = new GraphData();



        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        final LineChart<Number,Number> lineChart2 =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data

        long[] iterations = dater.reader(iteration);
        long[] times = dater.reader(time);
        long[] countNumberss = dater.reader(countNumbers);

        for (int i = 0; i < Maximum.MAXIMUM_FILES; i++)
            series.getData().add(new XYChart.Data(iterations[i], countNumberss[i]));

        for (int i = 0; i < Maximum.MAXIMUM_FILES; i++)
            series2.getData().add(new XYChart.Data(times[i], countNumberss[i]));


        Scene scene  = new Scene(lineChart,800,600);
        Scene scene2  = new Scene(lineChart2,800,600);
        lineChart.getData().add(series);
        lineChart2.getData().add(series2);

        stage.setScene(scene);
        stage.show();
        stage.setScene(scene2);

        stage.show();
    }
}
