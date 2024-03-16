import java.io.*;

public class Serializer {
    private static final String SERIALIZATION_FILE = "FlightTicketReservationSystem.ser.txt";

    public static void saveState(Service service) {
        try (FileOutputStream fileOutput = new FileOutputStream(SERIALIZATION_FILE);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
             objectOutput.writeObject(service);
             System.out.println("DATA SAVED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Service readState() throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(SERIALIZATION_FILE);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Service) objectInputStream.readObject();
        }
    }

    public static void clearData() {
        File file = new File(SERIALIZATION_FILE);
        if (file.exists()) {
            if (file.delete()) {
                try {
                    file.createNewFile(); // Recreate the file
                    System.out.println("Data has been cleared.");
                } catch (IOException e) {
                    System.out.println("Failed to recreate the file: " + e.getMessage());
                }
            } else {
                System.out.println("Failed to delete data.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    public static boolean checkFile() {
        File file = new File(SERIALIZATION_FILE);
        return file.exists() && file.length() != 0;
    }


}
