import java.awt.Graphics;
import java.awt.Frame;

public class Lander {
    private Vector2D vel = new Vector2D();
    private Vector2D accel = new Vector2D();
    private Vector2D pos = new Vector2D();
    private double rotation = 0;
    private double fuel = 0;
    private boolean thrust = false;
    private final double GRAVITY = -9.81/6;
    private final double THRUST_ACCEL = GRAVITY * 2;
    private boolean exploding = false;
    private Vector2D[] shapes;
    private Vector2D[] shapeVels;
    Frame frame;
    public Lander(Frame a) {
        vel.reset(0.415, 0);
        pos.reset();
        accel.reset(0, GRAVITY);
        rotation = 180;
        fuel = 1000;
        thrust = false;
        frame = a;
    }
    public void reset() {
        vel.reset(0.415, 0);
        pos.reset();
        accel.reset(0, GRAVITY);
        exploding = false;
        rotation = 180;
        fuel -= 200;
        thrust = false;
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].reset();
        }
    }
    public void rotate(boolean direction) {
        // false = left, true = right
        if (!direction) rotation += 15;
        else rotation -= 15;
        if (rotation < 0) rotation += 360;
        rotation %= 360;
    }
    public void setRotation(double newAngle) {
        rotation = newAngle;
    }
    public void setThrust(boolean newThrust) {
        thrust = newThrust;
    }
    public void thrusters() {
        if (thrust) {
            accel.setX(THRUST_ACCEL * Math.cos(rotation * Math.PI/180));
            accel.setY(GRAVITY + Math.sin(rotation * Math.PI/180));
        } else {
            accel.reset(0, GRAVITY);
        }
    }
    public Vector2D getPos() {
        return pos;
    }
    public void update() {
        thrusters();
        vel.addEq(accel);
        pos.addEq(vel);
        

    }
    public void render(Graphics g) {
        g.drawLine(5,5, 100, 100);
    }
    public void crash() {

    }
    public void land() {

    }
    public void renderShapes() {

    }
}
