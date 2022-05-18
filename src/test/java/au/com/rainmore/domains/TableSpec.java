package au.com.rainmore.domains;

import au.com.rainmore.BaseSpec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableSpec extends BaseSpec {

    @Test
    public void testIsValid() {
        Integer randomSize = getRandom().nextInt(100);
        Table table = Table.of(randomSize);

        Point validPoint = Point.of(getRandom().nextInt(randomSize), getRandom().nextInt(randomSize));
        Assertions.assertTrue(table.isValid(validPoint));

        Point invalidPoint1 = Point.of(getRandom().nextInt(randomSize) + 100, getRandom().nextInt(randomSize));
        Assertions.assertFalse(table.isValid(invalidPoint1));

        Point invalidPoint2 = Point.of(getRandom().nextInt(randomSize), getRandom().nextInt(randomSize) + 100);
        Assertions.assertFalse(table.isValid(invalidPoint2));

        Point invalidPoint3 = Point.of(getRandom().nextInt(randomSize) + 100, getRandom().nextInt(randomSize) + 100);
        Assertions.assertFalse(table.isValid(invalidPoint3));
    }

}
