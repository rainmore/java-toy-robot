package au.com.rainmore.actions;

import au.com.rainmore.domains.Robot;

import java.util.Optional;

public class Report implements Action {

    public String getMessage(Robot robot) {
        Optional<Place> currentPlace = robot.getCurrentPlace();
        String message;
        if (currentPlace.isPresent()) {
            message = String.format("Output: %d,%d,%s",
                    currentPlace.get().getPoint().getX(),
                    currentPlace.get().getPoint().getY(),
                    currentPlace.get().getFacing()
            );
        }
        else {
            message = "No Place Set";
        }

        return message;
    }

}
