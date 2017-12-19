package ru.itis;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class ShopService {

    public void addOwner(String name, int age, String city) throws IOException {
        try (FileWriter writer = new FileWriter("owners.txt", true)) {
            // запись всей строки
            int ID = readID("owners.txt") + 1;
            writer.write(String.valueOf(ID) + " " + name + " " + String.valueOf(age) + " " + city);

            writer.append('\n');

            writer.flush();
            System.out.println("Вы успешно зарегестрированы! Ваш ID - " + ID);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void addOrder(int ID, String name, int height) throws IOException {
        boolean truth = false;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("owners.txt"), StandardCharsets.UTF_8))) {
            String line;
            String  heightString[] = {"", "", "", ""};

            while ((line = reader.readLine()) != null) {
                for(int i = 0; i < heightString.length; i++){
                    heightString[i] = "";
                }
                char[] letters = line.toCharArray();
                int k = 0;
                for(int i = 0; i < letters.length; i++){
                    if (letters[i] != ' '){
                        heightString[k] += letters[i];
                    } else k++;
                }
                if(heightString[0].equals(String.valueOf(ID))) {
                    truth = true;
                }
            }

        } catch (IOException e) {
            // log error
        }
        if (truth) {
            try (FileWriter writer = new FileWriter("orders.txt", true)) {
                // запись всей строки
                int IDorder = readID("orders.txt") + 1;
                writer.write(String.valueOf(IDorder) + " " + String.valueOf(ID) + " " + name + " " + String.valueOf(height));

                writer.append('\n');

                writer.flush();
                System.out.println("Ваш товар успешно зарегестрирован! Ваш ID товара - " + IDorder);
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
        } else System.err.println("ID покупалеля не найден в БД. Чтобы добавить покупателя, вызовите метод addOwner");
    }

    public void currentHeight(int height) {
            // читаем посимвольно
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("orders.txt"), StandardCharsets.UTF_8))) {
                String line;
                String  heightString[] = {"", "", "", ""};


                while ((line = reader.readLine()) != null) {
                    for(int i = 0; i < heightString.length; i++){
                        heightString[i] = "";
                    }
                    char[] letters = line.toCharArray();
                    int k = 0;
                    for(int i = 0; i < letters.length; i++){
                        if (letters[i] != ' '){
                            heightString[k] += letters[i];
                        } else k++;
                    }
                if(heightString[3].equals(String.valueOf(height))) {
                    System.out.println(line);
                }
                }

        } catch (IOException e) {
            // log error
        }

    }

    public void currentCity(String city){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("owners.txt"), StandardCharsets.UTF_8))) {
            String line;
            String  heightString[] = {"", "", "", ""};

            while ((line = reader.readLine()) != null) {
                for(int i = 0; i < heightString.length; i++){
                    heightString[i] = "";
                }
                char[] letters = line.toCharArray();
                int k = 0;
                for(int i = 0; i < letters.length; i++){
                    if (letters[i] != ' '){
                        heightString[k] += letters[i];
                    } else k++;
                }
                if(heightString[3].equals(city)) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            // log error
        }
    }

    public void maxOrders() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("orders.txt"), StandardCharsets.UTF_8))) {
            String line;
            String  heightString[] = {"", "", "", ""};
            int[] IDs = new int[100];


            while ((line = reader.readLine()) != null) {
                for(int i = 0; i < heightString.length; i++){
                    heightString[i] = "";
                }
                char[] letters = line.toCharArray();
                int k = 0;
                for(int i = 0; i < letters.length; i++){
                    if (letters[i] != ' '){
                        heightString[k] += letters[i];
                    } else k++;
                }
                IDs[Integer.valueOf(heightString[1])]++;
            }
            int max = 0;
            int maxID = 0;
            for(int i = 0; i < IDs.length; i++){
                if (IDs[i] > max){
                    max = IDs[i];
                    maxID = i;
                }
            }
            System.out.println(maxID);

        } catch (IOException e) {
            // log error
        }
        //catch (ArrayIndexOutOfBoundsException e) {
          //  System.err.println("АЖИБКА");
        //}
    }

    public int readID(String fileName) {
        int ID = 0;
        try {
            String line = null;
            // читаем посимвольно
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName), StandardCharsets.UTF_8))) {
                String i;
                while ((i = reader.readLine()) != null) {
                    line = i;
                }
            } catch (IOException e) {
                // log error
            }
            char[] letters = line.toCharArray();
            int i = 0;
            while (letters[i] != ' ') {
                ID *= 10;
                ID += letters[i] - '0';
                i++;
            }
        } catch (NullPointerException e) {
            ID = 0;
        } catch (ArrayIndexOutOfBoundsException ex) {
            return ID;
        }

        return ID;
    }
}






