import java.lang.Math;

public class Vector2D {

    public double[] coords = {0.0, 0.0};

    public Vector2D(double x, double y) {
        coords[0] = x_coord;
        coords[1] = y_coord;
    }

    public Vector2D(double x_coord) {
        coords[0] = x_coord;
        coords[1] = 0.0;
    }

    public Vector2D() {
        coords[0] = 0.0;
        coords[1] = 0.0;
    }

    private void reset(double x_coord, double y_coord) {
        coords[0] = x_coord;
        coords[1] = y_coord;
    }

    private double magnitude() {
        return Math.sqrt(coords[0]*coords[0] + coords[1]*coords[1]);
    }

    private void scale(double a) {
        coords[0] *= a;
        coords[1] *= a;
    }

    private void addEq(float addend) {
        coords[0] += addend;
        coords[1] += addend;
    }

    private void addEq(Vector2D v) {
        coords[0] += v[0];
        coords[1] += v[1];
    }

    private double angle() {
        return Math.atan2(coords[1],coords[0]);
    }

    private void rotate(double angle) {

    }
}