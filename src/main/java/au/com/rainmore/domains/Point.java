package au.com.rainmore.domains;

import java.util.Objects;

public record Point(Integer x, Integer y) {

    public static Point of(Integer x, Integer y) {
        return new Point(x, y);
    }

    public Point withX(Integer x) {
        return Point.of(x, y());
    }

    public Point withY(Integer y) {
        return Point.of(x(), y);
    }

}
