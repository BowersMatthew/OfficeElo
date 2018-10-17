package Models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest extends ApplicationTest {

    private Player player1;
    @Before
    public void setUp() {
        player1 = new Player(1, "Matt", "Bowers", 1234);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFirstName_ThrowsException_When_TooShort() {
        player1.setFirstName("a");
    }

    private String[] badNames = {"12s4", "Matt2", "5Matt", "Test s2ace"};
    @Test
    public void setFirstName_ThrowsException_When_HasDigits() {
        int count = 0;
        int expected = 4;
        ArrayList<String> worked = new ArrayList<String>(5);
        for (String name : badNames)
        try {
            player1.setFirstName(name);
            worked.add(name);
        } catch (Exception e) {
            count++;
        }
        for (String name : worked) {
            System.out.println("Successful Names: " + name);
        }
        assertEquals(expected, count);
    }

    @Test
    public void setLastName_ThrowsException_When_HasDigits() {
        int count = 0;
        int expected = 4;
        ArrayList<String> worked = new ArrayList<String>(5);
        for (String name : badNames)
            try {
                player1.setLastName(name);
                worked.add(name);
            } catch (Exception e) {
                count++;
            }
        for (String name : worked) {
            System.out.println("Successful Names: " + name);
        }
        assertEquals(expected, count);
    }

    @Test
    public void setFirstNameSucceeds_When_LongEnough() {
        String testName = "John";
        player1.setFirstName(testName);
        assertSame("Should be same", testName, player1.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLastName_ThrowsException_When_TooShort() {
        String testName = "a";
        player1.setLastName(testName);
    }

    @Test
    public void setLastName_Succeeds_When_LongEnough() {
        String testName = "Wilson";
        player1.setLastName(testName);
        assertSame("Should be same", testName, player1.getLastName());
    }

    @Test
    public void checkPin_ReturnsTrue_When_PinsMatch() {
        assertTrue(player1.checkPin(1234));
    }

    @Test
    public void checkPin_ReturnsFalse_When_PinsDoNotMatch() {
        assertFalse(player1.checkPin(1235));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPin_ThrowsException_When_PinTooShort() {
        player1.setPin(999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPin_ThrowsException_When_PinTooLong() {
        player1.setPin(10000);
    }

    @Test
    public void setPin_Succeeds_When_PinIsFourDigits() {
        int newPin = 2345;
        // confirm old pin
        assertFalse(player1.checkPin(newPin));
        // change pin
        try{
            player1.setPin(newPin);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        // check successful change
        assertTrue(player1.checkPin(newPin));
    }

    @Test
    public void toStringTest() {
        String target = "Bowers, Matt";
        assertEquals(target, player1.toString());
    }

    @After
    public void tearDown() {
        player1 = null;
    }
}