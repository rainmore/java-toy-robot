package au.com.rainmore.domains;


public class Table {

    private final Integer size;

    private Table(Integer size) {
        this.size = size;
    }

    public static Table of(Integer size) {
        return new Table(size);
    }

    public Integer getSize() {
        return size;
    }

    public Boolean isValid(Point point) {
        return isValid(point.getX()) && isValid(point.getY());
    }

    private Boolean isValid(Integer integer) {
        return integer < getSize() && integer >= 0;
    }

}
