package ru.itis;

import java.io.File;

public class Deleter {
    String path = new File("").getAbsolutePath();

    //класс, удаляющий файлы

    void delete() {
        for (int i = 0; i < Maximum.MAXIMUM_FILES; i++) {
            String path = "\\file" + String.valueOf(i) + ".txt";
            File newFile = new File(this.path + "\\files" + path);
            newFile.delete();
        }
    }
}
