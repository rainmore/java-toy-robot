package au.com.rainmore.domains;

import java.util.Objects;

public class Point {

    private final Integer x;
    private final Integer y;

    private Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(Integer x, Integer y) {
        return new Point(x, y);
    }

    public Point withX(Integer x) {
        return new Point(x, getY());
    }

    public Point withY(Integer y) {
        return new Point(getX(), y);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return getX().equals(point.getX()) && getY().equals(point.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
