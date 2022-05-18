package au.com.rainmore.actions;

import au.com.rainmore.BaseSpec;
import au.com.rainmore.domains.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotateSpec extends BaseSpec {

    @Test
    public void testRotateToLeft() {
        Rotate rotate = new RotateToLeft();

        Assertions.assertEquals(true, rotate.isLeft());
        Assertions.assertEquals(false, rotate.isRight());

        Assertions.assertEquals(Direction.WEST, rotate.rotate(Direction.NORTH));
        Assertions.assertEquals(Direction.NORTH, rotate.rotate(Direction.EAST));
        Assertions.assertEquals(Direction.EAST, rotate.rotate(Direction.SOUTH));
        Assertions.assertEquals(Direction.SOUTH, rotate.rotate(Direction.WEST));
    }

    @Test
    public void testRotateToRight() {
        Rotate rotate = new RotateToRight();

        Assertions.assertEquals(false, rotate.isLeft());
        Assertions.assertEquals(true, rotate.isRight());

        Assertions.assertEquals(Direction.EAST, rotate.rotate(Direction.NORTH));
        Assertions.assertEquals(Direction.SOUTH, rotate.rotate(Direction.EAST));
        Assertions.assertEquals(Direction.WEST, rotate.rotate(Direction.SOUTH));
        Assertions.assertEquals(Direction.NORTH, rotate.rotate(Direction.WEST));
    }

}
