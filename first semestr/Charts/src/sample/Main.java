package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    public Array points;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scanner scanner = new Scanner(System.in);
        LineChart chart = new LineChart(new NumberAxis(), new NumberAxis());
        int n = scanner.nextInt();
        points = new Array(n);

//        Считываем значения с консоли
        for (int i= 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        points.sort();
        points.print();


//        Добавляем точки в линии
        while (points.size() >= points.getRemovedCount()) {
            int maxY = points.getY(0);
            int maxX = points.getX(0);
            int j;
            XYChart.Series tempLine = new XYChart.Series();

            tempLine.getData().add(new XYChart.Data<>(points.getX(0), points.getY(0)));
            points.remove(0);
            for (int i=0; i < points.size() ; i++){
                if (points.getY(i) >= maxY && points.getX(i) >= maxX && !points.isRemoved(i)){
                    maxY = points.getY(i);
                    maxX = points.getX(i);
                    j = i;
                    tempLine.getData().add(new XYChart.Data<>(points.getX(i), points.getY(i)));
                    points.remove(i);
                    i--;
                }
            }
            chart.getData().add(tempLine);
        }
//      Выводим все на экран
        VBox vBox = new VBox();
        vBox.getChildren().add(chart);
        primaryStage.setScene(new Scene(vBox));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}