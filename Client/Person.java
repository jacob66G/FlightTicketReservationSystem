package Client;

import java.util.ArrayList;

public class Person extends Client{
    private String name, surname, PESEL;
    public Person(String phoneNumber, String email, String name, String surname, String PESEL) {
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
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return "Client.Person Information:\n" +
                "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "PESEL: " + PESEL + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "Email: " + getEmail() + "\n";
    }
}
