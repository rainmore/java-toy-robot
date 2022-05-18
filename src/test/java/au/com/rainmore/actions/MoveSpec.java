package au.com.rainmore.actions;

import au.com.rainmore.BaseSpec;
import au.com.rainmore.domains.Direction;
import au.com.rainmore.domains.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class MoveSpec extends BaseSpec {

    private Move action = new Move();

    @Test
    public void testMove() {
        Point point = Point.of(generateRandomInteger(), generateRandomInteger());

        Point point1 = action.move(point, Direction.NORTH);
        Assertions.assertEquals(point.getX(), point1.getX());
        Assertions.assertEquals(point.getY() + 1, point1.getY());

        Point point2 = action.move(point, Direction.EAST);
        Assertions.assertEquals(point.getX() + 1, point2.getX());
        Assertions.assertEquals(point.getY(), point2.getY());

        Point point3 = action.move(point, Direction.SOUTH);
        Assertions.assertEquals(point.getX(), point3.getX());
        Assertions.assertEquals(point.getY() - 1, point3.getY());

        Point point4 = action.move(point, Direction.WEST);
        Assertions.assertEquals(point.getX() - 1, point4.getX());
        Assertions.assertEquals(point.getY(), point4.getY());
    }

    private Integer generateRandomInteger() {
        return getRandom().nextInt(100);
    }

}
