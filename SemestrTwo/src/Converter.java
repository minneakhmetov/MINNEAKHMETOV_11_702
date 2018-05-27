import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    private RandomCreator creator = new RandomCreator();
    //класс, конвертирующий данные из файла в массив или коллекцию

    public int[] convertArray(File file){
        int[] ints = new int[creator.size(file)];
        for (int i = 0; i < ints.length; i++)
            ints[i] = 0;

        try(FileReader reader = new FileReader(file))
        {
            // читаем посимвольно
            int c;
            int i = 0;
            while((c=reader.read())!=-1){
                if (c != ' '){
                    ints[i] *= 10;
                    ints[i] += (c - '0');
                }
                if (c == ' ')
                    i++;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return ints;
    }

    public List<Integer> convertList(File file){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < creator.size(file); i++)
            list.add(0);

        try(FileReader reader = new FileReader(file))
        {
            // читаем посимвольно
            int c;
            int i = 0;
            while((c=reader.read())!=-1){
                if (c != ' '){
                    //System.out.println(list.get(i));
                    list.set(i, list.get(i) * 10);
                    list.set(i, list.get(i) + (c - '0'));
                }
                if (c == ' ')
                    i++;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return list;
    }
}
