package au.com.rainmore.actions;

import au.com.rainmore.domains.Direction;
import au.com.rainmore.domains.Point;

public class Place implements Action {

    private final Direction facing;
    private final Point point;

    private Place(Point point, Direction facing) {
        this.point = point;
        this.facing = facing;
    }

    public static Place of(Point point, Direction facing) {
        return new Place(point, facing);
    }

    public static Place of(Integer x, Integer y, Direction facing) {
        return of(Point.of(x, y), facing);
    }

    public Direction getFacing() {
        return facing;
    }

    public Point getPoint() {
        return point;
    }

}
