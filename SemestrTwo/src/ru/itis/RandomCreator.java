package ru.itis;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomCreator {

    //класс, создаваемый файлы со случайными числами

    String path = new File("").getAbsolutePath();
    Random random = new Random();
    //количесвво создаваемый чисел в файле
    //int numbers = random.nextInt(101);


    public void create() {

        for (int i = 0; i < Maximum.MAXIMUM_FILES; i++) {
            String path = "\\file" + String.valueOf(i) + ".txt";
            File newFile = new File(this.path + "\\files" + path);
            try (FileWriter writer = new FileWriter(newFile, false)) {
                String text = "";
                int numbers = random.nextInt(101);
                for (int j = 0; j < numbers; j++)
                    text += String.valueOf(random.nextInt(100)) + " ";
                writer.write(text);
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public int size(File file) {
        int i = 0;
        try (FileReader reader = new FileReader(file)) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1)
                if (c == ' ')
                    i++;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        i++;
        return i;
    }
}
