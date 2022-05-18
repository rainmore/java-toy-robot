package au.com.rainmore.actions;

import au.com.rainmore.domains.Direction;
import au.com.rainmore.domains.Point;

public class Move implements Action {

    public Point move(Point point, Direction direction) {
        Point newPoint = null;
        switch (direction) {
            case NORTH:
                newPoint = point.withY(point.getY() + 1);
                break;
            case EAST:
                newPoint = point.withX(point.getX() + 1);
                break;
            case SOUTH:
                newPoint = point.withY(point.getY() - 1);
                break;
            case WEST:
                newPoint = point.withX(point.getX() - 1);
                break;
        }
        return newPoint;
    }

}
