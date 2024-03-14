import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person extends Client implements Serializable {
    private String name, surname, PESEL;
    public Person(int phoneNumber, String email, String name, String surname, String PESEL) {
        super(phoneNumber, email);
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
        this.tickets = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPESEL() {
        return PESEL;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return "Person Information:\n" +
                "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "PESEL: " + PESEL + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "Email: " + getEmail() + "\n";
    }
}
