package parcel;

public class CartesianCoordinate {
    private final double x; // in km
    private final double y; // in km

    public CartesianCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(CartesianCoordinate other) {
        return Math.sqrt(Math.pow((other.getX()-getX()), 2) + Math.pow((other.getY()-getY()),2));
    }


    @Override
    public String toString() {
        return
                "{x=" + x +
                ", y=" + y +
                '}';
    }
}
