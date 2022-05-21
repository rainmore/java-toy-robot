package au.com.rainmore.actions;

import au.com.rainmore.domains.Direction;

import static au.com.rainmore.domains.Direction.*;
import static au.com.rainmore.domains.Direction.NORTH;

public abstract class Rotate implements Action {

    public abstract Boolean isLeft();

    public Boolean isRight() {
        return !isLeft();
    }

    public Direction rotate(Direction direction) {
        return switch (direction) {
            case NORTH -> (this.isLeft()) ? WEST : EAST;
            case EAST -> (this.isLeft()) ? NORTH : SOUTH;
            case SOUTH -> (this.isLeft()) ? EAST : WEST;
            case WEST -> (this.isLeft()) ? SOUTH : NORTH;
        };
    }

}
