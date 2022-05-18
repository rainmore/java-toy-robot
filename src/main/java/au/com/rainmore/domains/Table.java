package au.com.rainmore.domains;


public class Table {

    private final Integer size;
    private final Point[][] matrix;

    public Table(Integer size) {
        this.size = size;
        this.matrix = new Point[size][size];
        initMatrix();
    }

    private void initMatrix() {
        for(int y = 0; y < size; y++) {
            Point[] row = new Point[size];
            for(int x = 0; x < size; x++) {
                row[x] = Point.of(x, y);
            }
            matrix[y] = row;
        }
    }

    public Integer getSize() {
        return size;
    }

    public Point[][] getMatrix() {
        return matrix;
    }
}
