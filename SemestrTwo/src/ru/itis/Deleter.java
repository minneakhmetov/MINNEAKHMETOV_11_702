package ru.itis;

import java.io.File;

public class Deleter {
    private String path = new File("").getAbsolutePath();

    //класс, удаляющий файлы

    void delete() {
        for (int i = 0; i < Maximum.MAXIMUM_FILES; i++) {
            String path = "\\file" + String.valueOf(i) + ".txt";
            File newFile = new File(this.path + "\\files" + path);
            newFile.delete();
        }
        File iteration = new File(path + "\\graphData\\iteration.txt");
        File time = new File(path + "\\graphData\\time.txt");
        iteration.delete();
        time.delete();
    }
}
