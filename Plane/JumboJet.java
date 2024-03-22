package Plane;

public class JumboJet extends Plane {
    private final double averageSpeed = 900; //km/h
    public JumboJet(String planeCode, int numbersOfSeats) {
        super(planeCode, numbersOfSeats);
    }

    public double getAverageSpeed(){
        return averageSpeed;
    }

}
