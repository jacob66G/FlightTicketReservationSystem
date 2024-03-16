public class BusinessJet extends Plane {
    private final double averageSpeed = 770; //km/h
    public BusinessJet(String planeCode, int numbersOfSeats) {
        super(planeCode, numbersOfSeats);
    }

    public double getAverageSpeed(){
        return averageSpeed;
    }
}
