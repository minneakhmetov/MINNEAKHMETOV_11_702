package sample;

public class Point {
    public int x;
    public int y;
    public boolean isRemoved = false;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreater(Point point) {
        if (this.x > point.x) {
            return true;
        }
        if (this.x == point.x) {
            if (this.y > point.y) return true;
        }
        return false;
    }

    public boolean isGreaterEqual(Point point) {
        if (this.x >= point.x) {
            if (this.y >= point.y) return true;
        }
        return false;
    }

    public void remove() {
        this.isRemoved = true;
    }
}