import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    //класс, перезаписывающий в файл отсортированные данные
    public void writeArray(int[] array, File file) {
        try (FileWriter writer = new FileWriter(file, false)) {
            String text = "";
            for (int i = 0; i < array.length; i++)
                text += String.valueOf(array[i]) + " ";
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void writeList(List list, File file){
        try (FileWriter writer = new FileWriter(file, false)) {
            String text = "";
            for (int i = 0; i < list.size(); i++)
                text += String.valueOf(list.get(i)) + " ";
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
