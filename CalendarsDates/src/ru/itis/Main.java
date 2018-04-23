package ru.itis;

import java.io.File;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        File file = new File("C://Users//razil//Desktop");
//
//        File[] files = file.listFiles();
//
//        for(int i = 0; i < files.length; i++){
//            Date date = new Date(files[i].lastModified());
//
//            System.out.println(files[i] + "  modified:" +   date);
//
//
//
//        }
        Date date  = new Date();
        System.out.println(date);

        Date date1 = new Date();

        date.setDate(date1.getDate() + 1);
        date.setMinutes(date.getMinutes() - 30);
        System.out.println(date);




    }

    static String stringConverter(String data) {
        String result = "";
        switch (String.valueOf(data.charAt(0)) + data.charAt(1) + data.charAt(2)) {
            case "Mon":
                result += "Понедельник";
                break;
            case "Tue":
                result += "Вторник";
                break;
            case "Wed":
                result += "Среда";
                break;
            case "Thu":
                result += "Четверг";
                break;
            case "Fri":
                result += "Пятница";
                break;
            case "Sat":
                result += "Суббота";
                break;
            case "Sun":
                result += "Воскресенье";
                break;
        }
        result += " ";
        result += String.valueOf(data.charAt(8)) + String.valueOf(data.charAt(9));
        result += " ";
        switch (String.valueOf(data.charAt(4)) + data.charAt(5) + data.charAt(6)) {
            case "Jan":
                result += "Январь";
                break;
            case "Feb":
                result += "Февраль";
                break;
            case "Mar":
                result += "Март";
                break;
            case "Apr":
                result += "Апрель";
                break;
            case "May":
                result += "Май";
                break;
            case "Jun":
                result += "Июнь";
                break;
            case "Jul":
                result += "Июль";
                break;
            case "Aug":
                result += "Август";
                break;
            case "Sep":
                result += "Сентябрь";
                break;
            case "Oct":
                result += "Октябрь";
                break;
            case "Nov":
                result += "Ноябрь";
                break;
            case "Dec":
                result += "Декабрь";
                break;
        }
        result += " ";
        for (int i = 11; i < 19; i++)
            result += String.valueOf(data.charAt(i));
        result += " ";
        for (int i = 24; i < 28; i++)
            result += String.valueOf(data.charAt(i));
        return result;
    }
    static Date copyDate(Date date){
        Date result = new Date();
        result.setTime(date.getTime());
        return result;
    }
}
