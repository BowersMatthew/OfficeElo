package Models;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Player {
    private Integer ID;
    private String firstName;
    private String lastName;
    private Integer pin;

    private static String nameError = "names must contain only letters and be at least 2 characters long";

    public Player() {

    }

    public Player(int ID, String firstName, String lastName, int pin ) throws IllegalArgumentException {
        setID(ID);
        setFirstName(firstName);
        setLastName(lastName);
        setPin(pin);
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName.length() < 2 || firstName.matches(".*\\d+.*"))
            throw new IllegalArgumentException(nameError);
        else this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName.length() < 2 || lastName.matches(".*\\d.*"))
            throw new IllegalArgumentException(nameError);
        else this.lastName = lastName;
    }

    public boolean checkPin(Integer pin) {
        return pin == this.pin.intValue();
    }

    public void setPin(int pin) throws IllegalArgumentException {
        if (Integer.toString(pin).length() != 4) throw new IllegalArgumentException("pin must be 4 digits long");
        else this.pin = pin;
    }

    @Override
    public String toString() {
        return this.lastName + ", " + this.firstName;
    }
}
