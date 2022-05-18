package au.com.rainmore.domains;

import au.com.rainmore.actions.*;

import java.util.*;

public class Robot {

    private final List<Action> actions = new ArrayList<>();

    private final List<Place> places = new ArrayList<>();

    private final Table table;

    private Robot(Table table) {
        this.table = table;
    }

    public static Robot of(Table table) {
        return new Robot(table);
    }

    public List<Action> getActions() {
        return Collections.unmodifiableList(actions);
    }

    public List<Place> getPlaces() {
        return Collections.unmodifiableList(places);
    }

    public Optional<Place> getCurrentPlace() {
        if (places.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(places.get(places.size() - 1));
        }
    }

    public Robot act(Action action) {
        actions.add(action);

        if (action instanceof Place) {
            actPlace((Place) action);
        }
        else if (action instanceof Move) {
            actMove((Move) action);
        }
        else if (action instanceof Rotate) {
            actRotate((Rotate) action);
        }
        else if (action instanceof Report) {
            actReport((Report) action);
        }

        return this;
    }

    private void actPlace(Place place) {
        if (table.isValid(place.getPoint())) {
            places.add(place);
        }
    }

    private void actMove(Move move) {
        Optional<Place> currentPlace = getCurrentPlace();
        if (currentPlace.isPresent()) {
            Point point = move.move(currentPlace.get().getPoint(), currentPlace.get().getFacing());
            Place place = currentPlace.get().withPoint(point);
            actPlace(place);
        }
    }

    private void actRotate(Rotate rotate) {
        Optional<Place> currentPlace = getCurrentPlace();
        if (currentPlace.isPresent()) {
            Direction newFacing = rotate.rotate(currentPlace.get().getFacing());
            Place place = currentPlace.get().withFacing(newFacing);
            places.add(place);
        }
    }

    private void actReport(Report report) {
        String message = report.getMessage(this);
        System.out.println(message);
    }

}
