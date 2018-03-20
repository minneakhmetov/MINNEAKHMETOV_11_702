package ru.itis;

import java.util.ArrayList;

public class MatrixImpl implements Matrix {
    public ArrayList<TableCell> cells = new ArrayList();

    public void set(int x, int y, int value){
        TableCell cell = new TableCell(x, y, value);
        boolean contents = false;
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i).equals(cell)){
                contents = true;
                break;
            }
        }
        if (!contents) cells.add(cell);
    }

    public int get(int x, int y){
        int cell = 0;
        for (int i = 0; i < cells.size(); i++)
            if (cells.get(i).getI() == x && cells.get(i).getJ() == y)
                cell = cells.get(i).getValue();
        return cell;
    }
}
