package Plane;

public class MidJet extends Plane{

    private final double averageSpeed = 900; //km/h
    public MidJet(String planeCode, int numbersOfSeats) {
        super(planeCode, numbersOfSeats);
    }

    @Override
    public double getAverageSpeed() {
        return averageSpeed;
    }

}
