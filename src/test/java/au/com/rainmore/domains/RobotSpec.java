package au.com.rainmore.domains;

import au.com.rainmore.BaseSpec;
import au.com.rainmore.actions.*;
import au.com.rainmore.input.StringToActionConvertor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class RobotSpec extends BaseSpec {

    private StringToActionConvertor convertor = new StringToActionConvertor();

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testAct() {
        Table table = buildTable();
        Robot robot = Robot.of(table);

        Assertions.assertTrue(robot.getCurrentPlace().isEmpty());
        Assertions.assertTrue(robot.getPlaces().isEmpty());

        robot.act(new Move());
        Assertions.assertTrue(robot.getCurrentPlace().isEmpty());
        Assertions.assertTrue(robot.getPlaces().isEmpty());

        robot.act(new Report());
        Assertions.assertTrue(robot.getCurrentPlace().isEmpty());
        Assertions.assertTrue(robot.getPlaces().isEmpty());

        robot.act(randomRotateAction());
        Assertions.assertTrue(robot.getCurrentPlace().isEmpty());
        Assertions.assertTrue(robot.getPlaces().isEmpty());

        Point point = randomPoint(table.getSize());

        Point invalidPoint = Point.of(point.getX() + table.getSize(), point.getY() + table.getSize());
        Place invalidPlace = Place.of(invalidPoint, randomDirection());
        robot.act(invalidPlace);
        Assertions.assertTrue(robot.getCurrentPlace().isEmpty());
        Assertions.assertTrue(robot.getPlaces().isEmpty());

        Place validPlace1 = Place.of(randomPoint(table.getSize()), randomDirection());
        robot.act(validPlace1);
        Assertions.assertTrue(robot.getCurrentPlace().isPresent());
        Assertions.assertEquals(1, robot.getPlaces().size());
        Assertions.assertEquals(validPlace1, robot.getCurrentPlace().get());
    }

    @Test
    public void testA() {
        Robot robot = buildDefaultRobot();

        Stream.of("PLACE 0,0,NORTH",
                        "MOVE",
                        "REPORT")
                .map(string -> convertor.convert(string))
                .forEach(robot::act);

        Assertions.assertEquals("Output: 0,1,NORTH", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testB() {
        Robot robot = buildDefaultRobot();

        Stream.of("PLACE 0,0,NORTH",
                        "LEFT",
                        "REPORT")
                .map(string -> convertor.convert(string))
                .forEach(robot::act);

        Assertions.assertEquals("Output: 0,0,WEST", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testC() {
        Robot robot = buildDefaultRobot();

        Stream.of("PLACE 1,2,EAST",
                        "MOVE",
                        "MOVE",
                        "LEFT",
                        "MOVE",
                        "REPORT")
                .map(string -> convertor.convert(string))
                .forEach(robot::act);

        Assertions.assertEquals("Output: 3,3,NORTH", outputStreamCaptor.toString().trim());
    }

    private Table buildTable() {
        return Table.of(getRandom().nextInt(10));
    }

    private Robot buildDefaultRobot() {
        Table table = Table.of(5);
        return Robot.of(table);
    }

    private Rotate randomRotateAction() {
        return getRandom().nextBoolean() ? new RotateToLeft() : new RotateToRight();
    }

    private Direction randomDirection() {
        List<Direction> directions = Arrays.asList(Direction.values());
        Collections.shuffle(directions);
        return directions.get(0);
    }

    private Point randomPoint(Integer size) {
        return Point.of(getRandom().nextInt(size), getRandom().nextInt(size));
    }
}
