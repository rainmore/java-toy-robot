package au.com.rainmore.actions;

import au.com.rainmore.domains.Direction;

import static au.com.rainmore.domains.Direction.*;

public enum Rotate implements Action {
    LEFT, RIGHT;

    public Direction rotate(Direction direction) {
        Direction rotatedDirection = null;
        switch (direction) {
            case NORTH:
                rotatedDirection = (this == LEFT) ? WEST : EAST;
                break;
            case EAST:
                rotatedDirection = (this == LEFT) ? NORTH : SOUTH;
                break;
            case SOUTH:
                rotatedDirection = (this == LEFT) ? EAST : WEST;
                break;
            case WEST:
                rotatedDirection = (this == LEFT) ? SOUTH : NORTH;
                break;
        }
        return rotatedDirection;
    }

}
