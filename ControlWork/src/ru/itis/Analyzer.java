package ru.itis;

import java.util.LinkedList;

public class Analyzer {

    LinkedList<String> list = new LinkedList<>();

    public void analyze(String input) {

        char[] inputChar = input.toCharArray();
        int state = 0;
        String temp = "";
        for (int i = 0; i < inputChar.length; i++) {
            switch (state) {
                case 0:
                    if ((inputChar[i] >= 'A' & inputChar[i] <= 'Z') | input.equals("")) {
                        temp += inputChar[i];
                        state++;
                    } else throw new SyntaxException();
                    break;
                case 1:
                    if (inputChar[i] >= '0' & inputChar[i] <= '9') {
                        temp += inputChar[i];
                        state++;
                    } else throw new SyntaxException();
                    break;
                case 2:
                    if (inputChar[i] == ':') {
                        temp += inputChar[i];
                        state++;
                    } else throw new SyntaxException();
                    break;
                case 3:
                    if (inputChar[i] == '=') {
                        temp += inputChar[i];
                        state++;
                    } else throw new SyntaxException();
                    break;
                case 4:
                    if ((inputChar[i] >= 'A' & inputChar[i] <= 'Z') | (inputChar[i] >= '0' & inputChar[i] <= '9') | inputChar[i] == ';') {
                        if (inputChar[i] >= 'A' & inputChar[i] <= 'Z') {
                            temp += inputChar[i];
                            state++;
                        }
                        if (inputChar[i] >= '0' & inputChar[i] <= '9') {
                            temp += inputChar[i];
                        }
                        if (inputChar[i] == ';') {
                            state = 0;
                            list.add(temp);
                            temp = "";
                        }
                    } else throw new SyntaxException();
                    break;
                case 5:
                    if (inputChar[i] >= '0' & inputChar[i] <= '9') {
                        temp += inputChar[i];
                        state++;
                    } else throw new SyntaxException();
                    break;
                case 6:
                    if (inputChar[i] == '+' | inputChar[i] == '-' | inputChar[i] == '/' | inputChar[i] == '*') {
                        temp += inputChar[i];
                        state++;
                    } else throw new SyntaxException();
                    break;
                case 7:
                    if ((inputChar[i] >= 'A' & inputChar[i] <= 'Z') | (inputChar[i] >= '0' & inputChar[i] <= '9') | inputChar[i] == ';') {
                        if (inputChar[i] >= 'A' & inputChar[i] <= 'Z') {
                            temp += inputChar[i];
                            state++;
                        }
                        if (inputChar[i] >= '0' & inputChar[i] <= '9') {
                            temp += inputChar[i];
                        }
                        if (inputChar[i] == ';') {
                            if (inputChar[i-1] >= '0' & inputChar[i-1] <= '9') {
                                state = 0;
                                list.add(temp);
                                temp = "";
                            } else throw new SyntaxException();
                        }
                    } else throw new SyntaxException();
                    break;
                case 8:
                    if (inputChar[i] >= '0' & inputChar[i] <= '9') {
                        temp += inputChar[i];
                        state++;
                    } else throw new SyntaxException();
                    break;
                case 9:
                    if (inputChar[i] == ';') {
                        state = 0;
                        list.add(temp);
                        temp = "";
                    }
            }
        }
        if (inputChar[inputChar.length - 1] != ';') throw new SyntaxException();
    }

    public LinkedList<String> process(LinkedList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(4) >= 'A' & list.get(i).charAt(4) <= 'Z') {
                String temp1 = "" + list.get(i).charAt(4) + list.get(i).charAt(5);
                String temp2 = "";
                int number = 0;
                if(list.get(i).charAt(7) >= 'A' & list.get(i).charAt(7) <= 'Z')
                    temp2 = "" + list.get(i).charAt(7) + list.get(i).charAt(8);
                else
                    if (list.get(i).charAt(7) >= '0' & list.get(i).charAt(7) <= '9') {
                        int j = 7;
                        try {
                            while (list.get(i).charAt(j) != '\n') {
                                number *= 10;
                                number += (list.get(i).charAt(j) - '0');
                                j++;
                            }
                        } catch (StringIndexOutOfBoundsException e){

                        }
                    }
                int result;
                String temp;
                switch (list.get(i).charAt(6)){
                    case '+':
                        if (temp2.equals(""))
                            result = find(list, temp1) + number;
                        else
                            result = find(list, temp1) + find(list, temp2);
                        temp = "" + list.get(i).charAt(0) + list.get(i).charAt(1) + list.get(i).charAt(2) + list.get(i).charAt(3) + String.valueOf(result);
                        list.set(i, temp);
                        break;
                    case '-':
                        if (temp2.equals(""))
                            result = find(list, temp1) - number;
                        else
                            result = find(list, temp1) - find(list, temp2);
                        temp = "" + list.get(i).charAt(0) + list.get(i).charAt(1) + list.get(i).charAt(2) + list.get(i).charAt(3) + String.valueOf(result);
                        list.set(i, temp);
                        break;
                    case '/':
                        if (temp2.equals(""))
                            result = find(list, temp1) / number;
                        else
                            result = find(list, temp1) / find(list, temp2);
                        temp = "" + list.get(i).charAt(0) + list.get(i).charAt(1) + list.get(i).charAt(2) + list.get(i).charAt(3) + String.valueOf(result);
                        list.set(i, temp);
                        break;
                    case '*':
                        if (temp2.equals(""))
                            result = find(list, temp1) * number;
                        else 
                            result = find(list, temp1) * find(list, temp2);
                        temp = "" + list.get(i).charAt(0) + list.get(i).charAt(1) + list.get(i).charAt(2) + list.get(i).charAt(3) + String.valueOf(result);
                        list.set(i, temp);
                        break;
                }
            }
        }
        return list;
    }

    public int find(LinkedList<String> list, String variable) {
        int result = 0;
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            String temp = "" + list.get(i).charAt(0) + list.get(i).charAt(1);
            if (variable.equals(temp)) {
                if (list.get(i).charAt(4) >= '0' & list.get(i).charAt(4) <= '9') {
                    flag = true;
                    for (int j = 4; j < list.get(i).length(); j++) {
                        result *= 10;
                        result += list.get(i).charAt(j) - '0';
                    }
                }
            }
        }
        if (flag)
            return result;
        else
            throw new NotFoundVariableException();
    }
}
