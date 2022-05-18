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
        Direction rotatedDirection = null;
        switch (direction) {
            case NORTH:
                rotatedDirection = (this.isLeft()) ? WEST : EAST;
                break;
            case EAST:
                rotatedDirection = (this.isLeft()) ? NORTH : SOUTH;
                break;
            case SOUTH:
                rotatedDirection = (this.isLeft()) ? EAST : WEST;
                break;
            case WEST:
                rotatedDirection = (this.isLeft()) ? SOUTH : NORTH;
                break;
        }
        return rotatedDirection;
    }

}
