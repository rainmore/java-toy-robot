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
        Assertions.assertEquals(point.x(), point1.x());
        Assertions.assertEquals(point.y() + 1, point1.y());

        Point point2 = action.move(point, Direction.EAST);
        Assertions.assertEquals(point.x() + 1, point2.x());
        Assertions.assertEquals(point.y(), point2.y());

        Point point3 = action.move(point, Direction.SOUTH);
        Assertions.assertEquals(point.x(), point3.x());
        Assertions.assertEquals(point.y() - 1, point3.y());

        Point point4 = action.move(point, Direction.WEST);
        Assertions.assertEquals(point.x() - 1, point4.x());
        Assertions.assertEquals(point.y(), point4.y());
    }

    private Integer generateRandomInteger() {
        return getRandom().nextInt(100);
    }

}
