package ru.itis;

import java.io.*;
import java.util.Scanner;

public class GraphData {

    private String path = new File("").getAbsolutePath() + "\\graphData";
    File iteration = new File(path + "\\iterationData.txt");
    File time = new File(path + "\\time.txt");

    public void writeIteration(int i) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(iteration, true))) {
            writer.write(String.valueOf(i));
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void writeTime(long millis) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(time, true))) {
            writer.write(String.valueOf(millis));
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public long[] reader(File file) {
        long[] array = new long[Maximum.MAXIMUM_FILES];
        try(FileReader reader = new FileReader(file))
        {
            // читаем посимвольно
            int c;
            int i = 0;
            while((c=reader.read())!=-1){
                if (c >= '0' & c <= '9'){
                    array[i] *= 10;
                    array[i] += (c - '0');
                }
                if (c == '\r')
                    i++;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return array;
    }
}
