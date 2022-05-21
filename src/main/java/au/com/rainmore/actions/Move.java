package au.com.rainmore.actions;

import au.com.rainmore.domains.Direction;
import au.com.rainmore.domains.Point;

public class Move implements Action {

    public Point move(Point point, Direction direction) {
        return switch (direction) {
            case NORTH -> point.withY(point.y() + 1);
            case EAST -> point.withX(point.x() + 1);
            case SOUTH -> point.withY(point.y() - 1);
            case WEST -> point.withX(point.x() - 1);
        };
    }

}
