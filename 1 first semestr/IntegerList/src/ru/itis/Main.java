package ru.itis;

public class Main {

    public static void main(String[] args) {
        IntegersList integersList = new IntegersList();
        integersList.printList();

        Function function = numbers -> {
            int sum = 0;
            while (numbers > 0){
                sum = sum + numbers % 10;
                numbers /= 10;
            }
            return sum;
        };

        Predicate predicate = numbers -> {
            if ((numbers % 2) != 0) {
                return true;
            }
            return false;
        };

        IntegersList list = new IntegersList();
        IntegersList newList2 = list.map(function);
        System.out.println("Исходный массив: ");
        list.printList();
        System.out.println("Преобразованный массив: ");
        newList2.printList();
        IntegersList newList = list.filter(predicate);
        System.out.println("Нечетные числа: ");
        newList.printList();


    }
}
