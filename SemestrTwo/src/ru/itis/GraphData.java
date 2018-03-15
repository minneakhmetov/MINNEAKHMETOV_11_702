package ru.itis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GraphData {

    private String path = new File("").getAbsolutePath() + "\\graphData";
    File iteration = new File(path + "\\iterationData.txt");
    File time = new File(path + "\\time.txt");

    public void writeIteration (int i){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(iteration, true))) {
            writer.write(String.valueOf(i));
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void writeTime(long millis){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(time, true))) {
            writer.write(String.valueOf(millis));
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
