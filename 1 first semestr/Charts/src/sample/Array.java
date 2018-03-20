package sample;



public class Array {
    int count = 0;
    Point points[];
    int removedCount = 0;

    public Array(int n) {
        this.points = new Point[n];
    }

    public void add(Point point) {
        points[count] = point;
        count++;
    }

    void sort() throws Exception {
        int N = points.length;
        for (int k = N / 2; k > 0; k--)
            downheap(points, k, N);
        do {
            Point T = points[0];
            points[0] = points[N - 1];
            points[N - 1] = T;
            N = N - 1;
            downheap(points, 1, N);
        } while (N > 1);
    }

    void downheap(Point a[], int k, int N) throws Exception {
        Point T = a[k - 1];

        //Смотрим потомков в пределах ветки
        while (k <= N / 2) {

            int j = k + k;//Левый потомок

            //Если есть правый потомок,
            //то сравниваем его с левым
            //и из них выбираем наибольший
            if ((j < N) && (a[j].isGreater(a[j - 1]))) j++;

            //Если родитель больше (или равен) наибольшего потомка...
            if (T.isGreaterEqual(a[j - 1])) {

                //... то значит всё в порядке в этой ветке
                break;
            } else { //Если родитель меньше наибольшего потомка...
                a[k - 1] = a[j - 1];
                k = j;
            }
        }
        a[k - 1] = T;

    }

    public void print() {
        for (int i=0; i < points.length; i++) {
            System.out.println(points[i].x + " " + points[i].y);
        }
    }

    public int size() {
        return count;
    }

    public int getX(int a) {
        return points[a].x;
    }
    public int getY(int a) {
        return points[a].y;
    }

    public void remove(int a) {
        points[a].remove();
        removedCount++;
    }

    public boolean isRemoved(int a) {
        return points[a].isRemoved;
    }

    public int getRemovedCount() {
        return removedCount;
    }
}
