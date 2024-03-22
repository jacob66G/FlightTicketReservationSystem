package Plane;

import java.io.Serializable;

public class Plane implements Serializable {
    private String planeCode;
    private int numbersOfSeats;
    private double averageSpeed;
    public Plane(String planeCode, int numbersOfSeats) {
        this.planeCode = planeCode;
        this.numbersOfSeats = numbersOfSeats;
    }

    public String getPlaneCode() {
        return planeCode;
    }

    public void setPlaneCode(String planeNumber) {
        this.planeCode = planeNumber;
    }

    public int getNumbersOfSeats() {
        return numbersOfSeats;
    }

    public void setNumbersOfSeats(int numbersOfSeats) {
        this.numbersOfSeats = numbersOfSeats;
    }

    public double getAverageSpeed(){
        return averageSpeed;
    }
    @Override
    public String toString() {
        return  "PLANE CODE: " + planeCode + "\n" +
                "NUMBER OF SEATS: " + numbersOfSeats + "\n";
    }

}
