package Coordinates;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private double x, y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates.Coordinates (X, Y): (" + x + ", " + y + ")";
    }
}
