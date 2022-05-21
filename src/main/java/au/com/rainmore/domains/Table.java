package au.com.rainmore.domains;


public record Table(Integer size) {

    public static Table of(Integer size) {
        return new Table(size);
    }

    public Integer getSize() {
        return size;
    }

    public Boolean isValid(Point point) {
        return isValid(point.x()) && isValid(point.y());
    }

    private Boolean isValid(Integer integer) {
        return integer < getSize() && integer >= 0;
    }

}
