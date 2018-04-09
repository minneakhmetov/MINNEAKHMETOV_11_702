package ru.itis;


public class Main {
    static final int W = 5;         // ширина рабочего поля
    static final int H = 5;         // высота рабочего поля
    static final int WALL = -1;         // непроходимая ячейка
    static final int BLANK = -2;         // свободная непомеченная ячейка

    static int[] px = new int[W * H];
    static int[] py = new int[W * H];      // координаты ячеек, входящих в путь
    static int len;                       // длина пути
    static int[][] grid = new int[H][W];

    public static void main(String[] args) {
          // рабочее поле
        grid[1][0] = -1;
        grid[1][1] = -1;
        grid[2][1] = -1;
        grid[3][1] = -1;
        grid[3][0] = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(lee(3, 3, 3, 0));

// Перед вызовом lee() массив grid заполнен значениями WALL и BLANK
    }

    static boolean lee(int ax, int ay, int bx, int by) {   // поиск пути из ячейки (ax, ay) в ячейку (bx, by)
        int[] dx = {1, 0, -1, 0};   // смещения, соответствующие соседям ячейки
        int[] dy = {0, 1, 0, -1};   // справа, снизу, слева и сверху
        int d, x, y, k;
        boolean stop;

        if (grid[ay][ax] == WALL || grid[by][bx] == WALL) return false;  // ячейка (ax, ay) или (bx, by) - стена

        // распространение волны
        d = 0;
        grid[ay][ax] = 0;            // стартовая ячейка помечена 0
        do {
            stop = true;               // предполагаем, что все свободные клетки уже помечены
            for (y = 0; y < H; ++y)
                for (x = 0; x < W; ++x)
                    if (grid[y][x] == d) {                       // ячейка (x, y) помечена числом d
                        for (k = 0; k < 4; ++k) {                  // проходим по всем непомеченным соседям
                            int iy = y + dy[k], ix = x + dx[k];
                            if (iy >= 0 && iy < H && ix >= 0 && ix < W &&
                                    grid[iy][ix] == BLANK) {
                                stop = false;              // найдены непомеченные клетки
                                grid[iy][ix] = d + 1;      // распространяем волну
                            }
                        }
                    }
            d++;
        } while (!stop && grid[by][bx] == BLANK);

        if (grid[by][bx] == BLANK) return false;  // путь не найден

        // восстановление пути
        len = grid[by][bx];            // длина кратчайшего пути из (ax, ay) в (bx, by)
        x = bx;
        y = by;
        d = len;
        while (d > 0) {
            px[d] = x;
            py[d] = y;                   // записываем ячейку (x, y) в путь
            d--;
            for (k = 0; k < 4; ++k) {
                int iy = y + dy[k], ix = x + dx[k];
                if (iy >= 0 && iy < H && ix >= 0 && ix < W &&
                        grid[iy][ix] == d) {
                    x = x + dx[k];
                    y = y + dy[k];           // переходим в ячейку, которая на 1 ближе к старту
                    break;
                }
            }
        }
        px[0] = ax;
        py[0] = ay;                    // теперь px[0..len] и py[0..len] - координаты ячеек пути
        return true;
    }


}
