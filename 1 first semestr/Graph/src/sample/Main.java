package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.Scanner;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series

        final int MAX = 100;
        XYChart.Series seriesArray[] = new XYChart.Series[MAX];
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Введите количество точек");
        int N = scanner.nextInt();

        int prevA = 0;
        int prevB = 0;
        int serie = 0;
        for (int i = 0; i < MAX; i++)
        seriesArray[i] = new XYChart.Series();
        int arrayA[] = new int[MAX];
        int arrayB[] = new int[MAX];
        int k = 0;

        for (int i = 0; i < N; i++) {
            System.out.println("ВВЕДИТЕ ТОЧКУ:");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a >= prevA) {
                seriesArray[serie].getData().add(new XYChart.Data(a, b));
                prevA = a;
                prevB = b;
            } else {
                arrayA[k] = a;
                arrayB[k] = b;
                k++;
            }
        }

        for (int j = 0; j < k; j++) {
            serie++;
            //seriesArray[serie] = new XYChart.Series();
            for (int i = 0; i < N; i++) {
                if (arrayA[i] >= prevA) {
                    seriesArray[serie].getData().add(new XYChart.Data(arrayA[i], arrayB[i]));
                    prevA = arrayA[i];
                    prevB = arrayB[i];
                }
            }
        }


        Scene scene  = new Scene(lineChart,800,600);


        lineChart.getData().addAll(seriesArray[0], seriesArray[1], seriesArray[2], seriesArray[3]);

        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {



        launch(args);

    }


}
