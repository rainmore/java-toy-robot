package au.com.rainmore.input;

import au.com.rainmore.BaseSpec;
import au.com.rainmore.actions.*;
import au.com.rainmore.domains.Direction;
import au.com.rainmore.domains.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringToActionConvertorSpec extends BaseSpec {

    private StringToActionConvertor convertor = new StringToActionConvertor();

    @Test
    public void testConvertREPORTAction() {
        String action = "REPORT";
        Assertions.assertTrue(convertor.convert(action) instanceof Report);
    }

    @Test
    public void testConvertMOVEAction() {
        String action = "MOVE";
        Assertions.assertTrue(convertor.convert(action) instanceof Move);
    }

    @Test
    public void testConvertLEFTAction() {
        String action = "LEFT";
        Assertions.assertTrue(convertor.convert(action) instanceof RotateToLeft);
    }

    @Test
    public void testConvertRIGHTAction() {
        String action = "RIGHT";
        Assertions.assertTrue(convertor.convert(action) instanceof RotateToRight);
    }

    @Test
    public void testConvertPLACEAction() {
        String validAction1 = "PLACE 0,0,EAST";
        Assertions.assertTrue(convertor.convert(validAction1) instanceof Place);
        Place place1 = (Place) convertor.convert(validAction1);
        Assertions.assertEquals(Direction.EAST, place1.getFacing());
        Assertions.assertEquals(Point.of(0, 0), place1.getPoint());

        String validAction2 = "PLACE 1,2,WEST";
        Assertions.assertTrue(convertor.convert(validAction2) instanceof Place);
        Place place2 = (Place) convertor.convert(validAction2);
        Assertions.assertEquals(Direction.WEST, place2.getFacing());
        Assertions.assertEquals(Point.of(1, 2), place2.getPoint());

        String validAction3 = "PLACE 4,1,NORTH";
        Assertions.assertTrue(convertor.convert(validAction3) instanceof Place);
        Place place3 = (Place) convertor.convert(validAction3);
        Assertions.assertEquals(Direction.NORTH, place3.getFacing());
        Assertions.assertEquals(Point.of(4, 1), place3.getPoint());

        String validAction4 = "PLACE 0,9,SOUTH";
        Assertions.assertTrue(convertor.convert(validAction4) instanceof Place);
        Place place4 = (Place) convertor.convert(validAction4);
        Assertions.assertEquals(Direction.SOUTH, place4.getFacing());
        Assertions.assertEquals(Point.of(0, 9), place4.getPoint());
    }

    @Test
    public void testConvertWithWrongString() {
        String wrongAction1 = "Lala";
        Assertions.assertNull(convertor.convert(wrongAction1));

        String wrongAction2 = "PLACE 100 009 SOUTH1";
        Assertions.assertNull(convertor.convert(wrongAction2));

        String wrongAction3 = "PLACE a 9 SOUTH";
        Assertions.assertNull(convertor.convert(wrongAction3));

        String wrongAction4 = "PLACE 3 bb SOUTH";
        Assertions.assertNull(convertor.convert(wrongAction4));
    }

}
