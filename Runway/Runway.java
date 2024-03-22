package Runway;

import java.io.Serializable;

public class Runway implements Serializable {
    private String number;
    public Runway(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return "RUNWAY CODE: " + number;
    }
}
