public class Vector2D {

    private double[] coords;

    public Vector2D(double x, double y) {
        coords[0] = x_coord;
        coords[1] = y_coord;
    }

    public Vector2D(double x_coord) {
        coords[0] = x_coord;
        coords[1] = x_coord;
    }

    public Vector2D() {
        coords[0] = 0.0;
        coords[1] = 0.0;
    }

    public double getX() {
        return coords[0];
    }

    public double getY() {
        return coords[1];
    }

    public void setX(double newX) {
        coords[0] = newX;
    }

    public void setY(double newY) {
        coods[1] = newY;
    }

    public void reset(double x_coord || 0.0, double y_coord || 0.0) {
        coords[0] = x_coord;
        coords[1] = y_coord;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(coords[0], 2) + Math.pow(coords[1], 2));
    }

    public double distanceTo(double x, double y) {
        return Math.sqrt(Math.pow(coords[0] - x, 2) + Math.pow(coords[1] - y, 2));
    }

    public void scale(double a) {
        coords[0] *= a;
        coords[1] *= a;
    }

    public void scaleX(double scalar) {
        coords[0] *= scalar;
    }

    public void scaleY(double scalar) {
        coords[1] *= scalar;
    }

    public void addX(double addend) {
        coords[0] += addend;
    }

    public void addY(double addend) {
        coords[1] += addend;
    }

    public void addEq(float addend) {
        coords[0] += addend;
        coords[1] += addend;
    }

    public void addEq(Vector2D v) {
        coords[0] += v.getX();
        coords[1] += v.getY();
    }

    public double angle() {
        if (coords[0] == 0) return Math.PI/2;
        return Math.atan(coords[1]/coords[0]);
    }

    public void rotate(double angleInRadians) {
        double cosRY = Math.cos(angle);
        double sinRY = Math.sin(angle);
        double x = coords[0];
        double y = coords[1];
        coords[0] = (x*cosRY)-(y*sinRY);
        coords[1] = (x*sinRY)+(y*cosRY);
    }
}