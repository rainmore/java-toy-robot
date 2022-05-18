package au.com.rainmore.input;

import au.com.rainmore.actions.*;
import au.com.rainmore.domains.Direction;
import au.com.rainmore.domains.Point;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringToActionConvertor implements Convertor<String, Action> {

    @Override
    public Action convert(String from) {
        if (from.equals("REPORT")) {
            return new Report();
        }
        else if (from.equals("MOVE")) {
            return new Move();
        }
        else if (from.equals("LEFT")) {
            return new RotateToLeft();
        }
        else if (from.equals("RIGHT")) {
            return new RotateToRight();
        }
        else {
            Pattern pattern = buildPlaceActionPattern();
            Matcher matcher = pattern.matcher(from);
            if (matcher.matches()) {
                Integer x = Integer.valueOf(matcher.group("x"));
                Integer y = Integer.valueOf(matcher.group("y"));
                Direction direction = Direction.valueOf(matcher.group("facing"));
                Point point = Point.of(x, y);
                return Place.of(point, direction);
            }
        }

        return null;
    }

    private Pattern buildPlaceActionPattern() {
        String directionsPattern = Arrays.stream(Direction.values()).map(Objects::toString).collect(Collectors.joining("|"));
        String pattern = "PLACE (?<x>\\d*),(?<y>\\d*),(?<facing>(" + directionsPattern + "))";
        return Pattern.compile(pattern);
    }
}
