package au.com.rainmore.actions;

import au.com.rainmore.domains.Direction;
import au.com.rainmore.domains.Point;

public record Place(Point point, Direction facing) implements Action {

    public static Place of(Point point, Direction facing) {
        return new Place(point, facing);
    }

    public Place withFacing(Direction facing) {
        return of(point(), facing);
    }

    public Place withPoint(Point point) {
        return of(point, facing());
    }

}
