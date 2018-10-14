package Models;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Player {
    private Integer ID;
    private String firstName;
    private String lastName;
    private Integer pin;

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
        if (firstName.length() < 2) throw new IllegalArgumentException("First Name must have at least two letters");
        else this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName.length() < 2) throw new IllegalArgumentException("Last Name must have at least two letters");
        else this.lastName = lastName;
    }

    private Integer getPin() {
        return pin;
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
