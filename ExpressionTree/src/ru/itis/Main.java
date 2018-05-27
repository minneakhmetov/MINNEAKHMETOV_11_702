package ru.itis;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        String string = "(3 + 3) + 5";

        for (int i = 0; i < string.length(); i++) {
            if (isDigit(string.charAt(i))) {
                int result = 0;
                try {
                    while (string.charAt(i) != ' ' & string.charAt(i) != ')' & i < string.length()) {
                        result *= 10;
                        result += string.charAt(i++) - '0';
                    }
                } catch (StringIndexOutOfBoundsException e) {
                }
                tree.add(result);
                i--;
            }
            if (isOperator(string.charAt(i)))
                tree.add(string.charAt(i));
        }
        tree.print();
    }

    static boolean isDigit(char c) {
        if (c >= '0' & c <= '9')
            return true;
        else return false;
    }

    static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        else return false;
    }


}
