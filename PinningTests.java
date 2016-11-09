import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PinningTests {

    @Test
    public void getFirstMonkeyAssertNull() throws Exception {
        List<Monkey> ml = new LinkedList<>();
        assertNull(MonkeySim.getFirstMonkey(ml));
    }

    @Test
    public void getFirstMonkeyTestAssertNotSame() throws Exception {
        Monkey firstMonkey = new Monkey();
        Monkey secondMonkey = new Monkey();
        List<Monkey> ml = new LinkedList<>();
        ml.add(firstMonkey);
        ml.add(secondMonkey);
        Monkey currMonkey = MonkeySim.getFirstMonkey(ml);
        assertNotSame(currMonkey, firstMonkey);
    }

    @Test
    public void getFirstMonkeyTestSame() {
        Monkey firstMonkey = new Monkey();
        Monkey secondMonkey = new Monkey();
        List<Monkey> ml = new LinkedList<>();
        ml.add(firstMonkey);
        ml.add(secondMonkey);
        Monkey currMonkey = MonkeySim.getFirstMonkey(ml);
        assertNotEquals(currMonkey, firstMonkey);
    }

    @Test
    public void stringifyResultsMonkey1To2() throws NoIdException {
        Monkey firstMonkey = new Monkey();
        firstMonkey.generateId(0);
        Monkey secondMonkey = new Monkey();
        secondMonkey.generateId(1);
        int firstId = firstMonkey.getId();
        int secondId = secondMonkey.getId();
        String output = "//Round 1: Threw banana from Monkey (#" + firstMonkey.getMonkeyNum() + " / ID "
                + firstId + ") to Monkey (#" + secondMonkey.getMonkeyNum() + " / ID " + secondId + ")";
        assertEquals(MonkeySim.stringifyResults(1, firstMonkey, secondMonkey), output);
    }

    @Test
    public void stringifyResultsMonkey1To3() throws NoIdException {
        Monkey firstMonkey = new Monkey();
        firstMonkey.generateId(0);
        Monkey thirdMonkey = new Monkey();
        thirdMonkey.generateId(2);
        int firstId = firstMonkey.getId();
        int secondId = thirdMonkey.getId();
        String output = "//Round 1: Threw banana from Monkey (#" + firstMonkey.getMonkeyNum() + " / ID "
                + firstId + ") to Monkey (#" + thirdMonkey.getMonkeyNum() + " / ID " + secondId + ")";
        assertEquals(MonkeySim.stringifyResults(1, firstMonkey, thirdMonkey), output);
    }

    @Test
    public void stringifyResultsMonkey2To3() throws NoIdException {
        Monkey secondMonkey = new Monkey();
        secondMonkey.generateId(1);
        Monkey thirdMonkey = new Monkey();
        thirdMonkey.generateId(2);
        int firstId = secondMonkey.getId();
        int secondId = thirdMonkey.getId();
        String output = "//Round 1: Threw banana from Monkey (#" + secondMonkey.getMonkeyNum() + " / ID "
                + firstId + ") to Monkey (#" + thirdMonkey.getMonkeyNum() + " / ID " + secondId + ")";
        assertEquals(MonkeySim.stringifyResults(1, secondMonkey, thirdMonkey), output);
    }

    @Test
    public void stringifyResultsNotNull() {
        Monkey firstMonkey = new Monkey();
        firstMonkey.generateId(0);
        Monkey secondMonkey = new Monkey();
        secondMonkey.generateId(1);
        assertNotNull(MonkeySim.stringifyResults(1, firstMonkey, secondMonkey));
    }

    @Test
    public void generateId() {
        Monkey firstMonkey = new Monkey();
        assertEquals(firstMonkey.generateId(0), 223492);
    }

    @Test
    public void generateIdNotEquals() {
        Monkey secondMonkey = new Monkey();
        assertNotEquals(secondMonkey.generateId(1), 1);
    }

    @Test
    public void generateIdNotNull() {
        Monkey thirdMonkey = new Monkey();
        assertNotNull(thirdMonkey.generateId(2));
    }
}
